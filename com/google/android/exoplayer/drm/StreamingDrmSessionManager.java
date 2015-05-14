package com.google.android.exoplayer.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaDrm;
import android.media.MediaDrm.KeyRequest;
import android.media.MediaDrm.OnEventListener;
import android.media.MediaDrm.ProvisionRequest;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@TargetApi(18)
public class StreamingDrmSessionManager
  implements DrmSessionManager
{
  private static final int MSG_KEYS = 1;
  private static final int MSG_PROVISION;
  final MediaDrmCallback callback;
  private final Handler eventHandler;
  private final EventListener eventListener;
  private Exception lastException;
  private MediaCrypto mediaCrypto;
  private final MediaDrm mediaDrm;
  final MediaDrmHandler mediaDrmHandler;
  private String mimeType;
  private int openCount;
  private final HashMap<String, String> optionalKeyRequestParameters;
  private Handler postRequestHandler;
  final PostResponseHandler postResponseHandler;
  private boolean provisioningInProgress;
  private HandlerThread requestHandlerThread;
  private byte[] schemePsshData;
  private byte[] sessionId;
  private int state;
  final UUID uuid;

  @Deprecated
  public StreamingDrmSessionManager(UUID paramUUID, Looper paramLooper, MediaDrmCallback paramMediaDrmCallback, Handler paramHandler, EventListener paramEventListener)
    throws UnsupportedSchemeException
  {
    this(paramUUID, paramLooper, paramMediaDrmCallback, null, paramHandler, paramEventListener);
  }

  public StreamingDrmSessionManager(UUID paramUUID, Looper paramLooper, MediaDrmCallback paramMediaDrmCallback, HashMap<String, String> paramHashMap, Handler paramHandler, EventListener paramEventListener)
    throws UnsupportedSchemeException
  {
    this.uuid = paramUUID;
    this.callback = paramMediaDrmCallback;
    this.optionalKeyRequestParameters = paramHashMap;
    this.eventHandler = paramHandler;
    this.eventListener = paramEventListener;
    this.mediaDrm = new MediaDrm(paramUUID);
    this.mediaDrm.setOnEventListener(new MediaDrmEventListener(null));
    this.mediaDrmHandler = new MediaDrmHandler(paramLooper);
    this.postResponseHandler = new PostResponseHandler(paramLooper);
    this.state = 1;
  }

  private void onError(final Exception paramException)
  {
    this.lastException = paramException;
    if ((this.eventHandler != null) && (this.eventListener != null))
      this.eventHandler.post(new Runnable()
      {
        public void run()
        {
          StreamingDrmSessionManager.this.eventListener.onDrmSessionManagerError(paramException);
        }
      });
    if (this.state != 4)
      this.state = 0;
  }

  private void onKeyResponse(Object paramObject)
  {
    if ((this.state != 3) && (this.state != 4))
      return;
    if ((paramObject instanceof Exception))
    {
      onKeysError((Exception)paramObject);
      return;
    }
    try
    {
      this.mediaDrm.provideKeyResponse(this.sessionId, (byte[])paramObject);
      this.state = 4;
      return;
    }
    catch (Exception localException)
    {
      onKeysError(localException);
    }
  }

  private void onKeysError(Exception paramException)
  {
    if ((paramException instanceof NotProvisionedException))
    {
      postProvisionRequest();
      return;
    }
    onError(paramException);
  }

  private void onProvisionResponse(Object paramObject)
  {
    this.provisioningInProgress = false;
    if ((this.state != 2) && (this.state != 3) && (this.state != 4))
      return;
    if ((paramObject instanceof Exception))
    {
      onError((Exception)paramObject);
      return;
    }
    try
    {
      this.mediaDrm.provideProvisionResponse((byte[])paramObject);
      if (this.state == 2)
      {
        openInternal(false);
        return;
      }
    }
    catch (DeniedByServerException localDeniedByServerException)
    {
      onError(localDeniedByServerException);
      return;
    }
    postKeyRequest();
  }

  private void openInternal(boolean paramBoolean)
  {
    try
    {
      this.sessionId = this.mediaDrm.openSession();
      this.mediaCrypto = new MediaCrypto(this.uuid, this.sessionId);
      this.state = 3;
      postKeyRequest();
      return;
    }
    catch (NotProvisionedException localNotProvisionedException)
    {
      if (paramBoolean)
      {
        postProvisionRequest();
        return;
      }
      onError(localNotProvisionedException);
      return;
    }
    catch (Exception localException)
    {
      onError(localException);
    }
  }

  private void postKeyRequest()
  {
    try
    {
      MediaDrm.KeyRequest localKeyRequest = this.mediaDrm.getKeyRequest(this.sessionId, this.schemePsshData, this.mimeType, 1, this.optionalKeyRequestParameters);
      this.postRequestHandler.obtainMessage(1, localKeyRequest).sendToTarget();
      return;
    }
    catch (NotProvisionedException localNotProvisionedException)
    {
      onKeysError(localNotProvisionedException);
    }
  }

  private void postProvisionRequest()
  {
    if (this.provisioningInProgress)
      return;
    this.provisioningInProgress = true;
    MediaDrm.ProvisionRequest localProvisionRequest = this.mediaDrm.getProvisionRequest();
    this.postRequestHandler.obtainMessage(0, localProvisionRequest).sendToTarget();
  }

  public void close()
  {
    int i = -1 + this.openCount;
    this.openCount = i;
    if (i != 0);
    do
    {
      return;
      this.state = 1;
      this.provisioningInProgress = false;
      this.mediaDrmHandler.removeCallbacksAndMessages(null);
      this.postResponseHandler.removeCallbacksAndMessages(null);
      this.postRequestHandler.removeCallbacksAndMessages(null);
      this.postRequestHandler = null;
      this.requestHandlerThread.quit();
      this.requestHandlerThread = null;
      this.schemePsshData = null;
      this.mediaCrypto = null;
      this.lastException = null;
    }
    while (this.sessionId == null);
    this.mediaDrm.closeSession(this.sessionId);
    this.sessionId = null;
  }

  public Exception getError()
  {
    if (this.state == 0)
      return this.lastException;
    return null;
  }

  public MediaCrypto getMediaCrypto()
  {
    if ((this.state != 3) && (this.state != 4))
      throw new IllegalStateException();
    return this.mediaCrypto;
  }

  public final byte[] getPropertyByteArray(String paramString)
  {
    return this.mediaDrm.getPropertyByteArray(paramString);
  }

  public final String getPropertyString(String paramString)
  {
    return this.mediaDrm.getPropertyString(paramString);
  }

  public int getState()
  {
    return this.state;
  }

  public void open(Map<UUID, byte[]> paramMap, String paramString)
  {
    int i = 1 + this.openCount;
    this.openCount = i;
    if (i != 1)
      return;
    if (this.postRequestHandler == null)
    {
      this.requestHandlerThread = new HandlerThread("DrmRequestHandler");
      this.requestHandlerThread.start();
      this.postRequestHandler = new PostRequestHandler(this.requestHandlerThread.getLooper());
    }
    if (this.schemePsshData == null)
    {
      this.mimeType = paramString;
      this.schemePsshData = ((byte[])paramMap.get(this.uuid));
      if (this.schemePsshData == null)
      {
        onError(new IllegalStateException("Media does not support uuid: " + this.uuid));
        return;
      }
    }
    this.state = 2;
    openInternal(true);
  }

  public boolean requiresSecureDecoderComponent(String paramString)
  {
    if ((this.state != 3) && (this.state != 4))
      throw new IllegalStateException();
    return this.mediaCrypto.requiresSecureDecoderComponent(paramString);
  }

  public static abstract interface EventListener
  {
    public abstract void onDrmSessionManagerError(Exception paramException);
  }

  private class MediaDrmEventListener
    implements MediaDrm.OnEventListener
  {
    private MediaDrmEventListener()
    {
    }

    public void onEvent(MediaDrm paramMediaDrm, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
    {
      StreamingDrmSessionManager.this.mediaDrmHandler.sendEmptyMessage(paramInt1);
    }
  }

  @SuppressLint({"HandlerLeak"})
  private class MediaDrmHandler extends Handler
  {
    public MediaDrmHandler(Looper arg2)
    {
      super();
    }

    public void handleMessage(Message paramMessage)
    {
      if ((StreamingDrmSessionManager.this.openCount == 0) || ((StreamingDrmSessionManager.this.state != 3) && (StreamingDrmSessionManager.this.state != 4)))
        return;
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        StreamingDrmSessionManager.access$302(StreamingDrmSessionManager.this, 3);
        StreamingDrmSessionManager.this.postProvisionRequest();
        return;
      case 2:
        StreamingDrmSessionManager.this.postKeyRequest();
        return;
      case 3:
      }
      StreamingDrmSessionManager.access$302(StreamingDrmSessionManager.this, 3);
      StreamingDrmSessionManager.this.postKeyRequest();
    }
  }

  @SuppressLint({"HandlerLeak"})
  private class PostRequestHandler extends Handler
  {
    public PostRequestHandler(Looper arg2)
    {
      super();
    }

    public void handleMessage(Message paramMessage)
    {
      Object localObject;
      try
      {
        switch (paramMessage.what)
        {
        default:
          throw new RuntimeException();
        case 0:
        case 1:
        }
      }
      catch (Exception localException)
      {
        localObject = localException;
      }
      while (true)
      {
        StreamingDrmSessionManager.this.postResponseHandler.obtainMessage(paramMessage.what, localObject).sendToTarget();
        return;
        localObject = StreamingDrmSessionManager.this.callback.executeProvisionRequest(StreamingDrmSessionManager.this.uuid, (MediaDrm.ProvisionRequest)paramMessage.obj);
        continue;
        byte[] arrayOfByte = StreamingDrmSessionManager.this.callback.executeKeyRequest(StreamingDrmSessionManager.this.uuid, (MediaDrm.KeyRequest)paramMessage.obj);
        localObject = arrayOfByte;
      }
    }
  }

  @SuppressLint({"HandlerLeak"})
  private class PostResponseHandler extends Handler
  {
    public PostResponseHandler(Looper arg2)
    {
      super();
    }

    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 0:
        StreamingDrmSessionManager.this.onProvisionResponse(paramMessage.obj);
        return;
      case 1:
      }
      StreamingDrmSessionManager.this.onKeyResponse(paramMessage.obj);
    }
  }
}