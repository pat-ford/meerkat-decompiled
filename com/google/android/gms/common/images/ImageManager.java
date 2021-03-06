package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzkv;
import com.google.android.gms.internal.zzme;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager
{
  private static final Object zzOl = new Object();
  private static HashSet<Uri> zzOm = new HashSet();
  private static ImageManager zzOn;
  private static ImageManager zzOo;
  private final Context mContext;
  private final Handler mHandler;
  private final ExecutorService zzOp;
  private final zzb zzOq;
  private final zzkm zzOr;
  private final Map<zza, ImageReceiver> zzOs;
  private final Map<Uri, ImageReceiver> zzOt;
  private final Map<Uri, Long> zzOu;

  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new Handler(Looper.getMainLooper());
    this.zzOp = Executors.newFixedThreadPool(4);
    if (paramBoolean)
    {
      this.zzOq = new zzb(this.mContext);
      if (zzme.zzkg())
        zziE();
    }
    while (true)
    {
      this.zzOr = new zzkm();
      this.zzOs = new HashMap();
      this.zzOt = new HashMap();
      this.zzOu = new HashMap();
      return;
      this.zzOq = null;
    }
  }

  public static ImageManager create(Context paramContext)
  {
    return zzb(paramContext, false);
  }

  private Bitmap zza(zza.zza paramzza)
  {
    if (this.zzOq == null)
      return null;
    return (Bitmap)this.zzOq.get(paramzza);
  }

  public static ImageManager zzb(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (zzOo == null)
        zzOo = new ImageManager(paramContext, true);
      return zzOo;
    }
    if (zzOn == null)
      zzOn = new ImageManager(paramContext, false);
    return zzOn;
  }

  private void zziE()
  {
    this.mContext.registerComponentCallbacks(new zze(this.zzOq));
  }

  public void loadImage(ImageView paramImageView, int paramInt)
  {
    zza(new zza.zzb(paramImageView, paramInt));
  }

  public void loadImage(ImageView paramImageView, Uri paramUri)
  {
    zza(new zza.zzb(paramImageView, paramUri));
  }

  public void loadImage(ImageView paramImageView, Uri paramUri, int paramInt)
  {
    zza.zzb localzzb = new zza.zzb(paramImageView, paramUri);
    localzzb.zzaC(paramInt);
    zza(localzzb);
  }

  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    zza(new zza.zzc(paramOnImageLoadedListener, paramUri));
  }

  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    zza.zzc localzzc = new zza.zzc(paramOnImageLoadedListener, paramUri);
    localzzc.zzaC(paramInt);
    zza(localzzc);
  }

  public void zza(zza paramzza)
  {
    zzb.zzbd("ImageManager.loadImage() must be called in the main thread");
    new zzd(paramzza).run();
  }

  private final class ImageReceiver extends ResultReceiver
  {
    private final Uri mUri;
    private final ArrayList<zza> zzOv;

    ImageReceiver(Uri arg2)
    {
      super();
      Object localObject;
      this.mUri = localObject;
      this.zzOv = new ArrayList();
    }

    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      ParcelFileDescriptor localParcelFileDescriptor = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager.zzf(ImageManager.this).execute(new ImageManager.zzc(ImageManager.this, this.mUri, localParcelFileDescriptor));
    }

    public void zzb(zza paramzza)
    {
      zzb.zzbd("ImageReceiver.addImageRequest() must be called in the main thread");
      this.zzOv.add(paramzza);
    }

    public void zzc(zza paramzza)
    {
      zzb.zzbd("ImageReceiver.removeImageRequest() must be called in the main thread");
      this.zzOv.remove(paramzza);
    }

    public void zziH()
    {
      Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
      localIntent.putExtra("com.google.android.gms.extras.uri", this.mUri);
      localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
      localIntent.putExtra("com.google.android.gms.extras.priority", 3);
      ImageManager.zzb(ImageManager.this).sendBroadcast(localIntent);
    }
  }

  public static abstract interface OnImageLoadedListener
  {
    public abstract void onImageLoaded(Uri paramUri, Drawable paramDrawable, boolean paramBoolean);
  }

  private static final class zza
  {
    static int zza(ActivityManager paramActivityManager)
    {
      return paramActivityManager.getLargeMemoryClass();
    }
  }

  private static final class zzb extends zzkv<zza.zza, Bitmap>
  {
    public zzb(Context paramContext)
    {
      super();
    }

    private static int zzO(Context paramContext)
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      int i;
      if ((0x100000 & paramContext.getApplicationInfo().flags) != 0)
      {
        i = 1;
        if ((i == 0) || (!zzme.zzkd()))
          break label55;
      }
      label55: for (int j = ImageManager.zza.zza(localActivityManager); ; j = localActivityManager.getMemoryClass())
      {
        return (int)(0.33F * (j * 1048576));
        i = 0;
        break;
      }
    }

    protected int zza(zza.zza paramzza, Bitmap paramBitmap)
    {
      return paramBitmap.getHeight() * paramBitmap.getRowBytes();
    }

    protected void zza(boolean paramBoolean, zza.zza paramzza, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      super.entryRemoved(paramBoolean, paramzza, paramBitmap1, paramBitmap2);
    }
  }

  private final class zzc
    implements Runnable
  {
    private final Uri mUri;
    private final ParcelFileDescriptor zzOx;

    public zzc(Uri paramParcelFileDescriptor, ParcelFileDescriptor arg3)
    {
      this.mUri = paramParcelFileDescriptor;
      Object localObject;
      this.zzOx = localObject;
    }

    public void run()
    {
      zzb.zzbe("LoadBitmapFromDiskRunnable can't be executed in the main thread");
      ParcelFileDescriptor localParcelFileDescriptor = this.zzOx;
      Object localObject = null;
      boolean bool = false;
      if (localParcelFileDescriptor != null);
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeFileDescriptor(this.zzOx.getFileDescriptor());
        localObject = localBitmap;
      }
      catch (OutOfMemoryError localIOException)
      {
        try
        {
          this.zzOx.close();
          localCountDownLatch = new CountDownLatch(1);
          ImageManager.zzg(ImageManager.this).post(new ImageManager.zzf(ImageManager.this, this.mUri, localObject, bool, localCountDownLatch));
        }
        catch (IOException localIOException)
        {
          try
          {
            while (true)
            {
              CountDownLatch localCountDownLatch;
              localCountDownLatch.await();
              return;
              localOutOfMemoryError = localOutOfMemoryError;
              Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, localOutOfMemoryError);
              bool = true;
              localObject = null;
            }
            localIOException = localIOException;
            Log.e("ImageManager", "closed failed", localIOException);
          }
          catch (InterruptedException localInterruptedException)
          {
            Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
          }
        }
      }
    }
  }

  private final class zzd
    implements Runnable
  {
    private final zza zzOy;

    public zzd(zza arg2)
    {
      Object localObject;
      this.zzOy = localObject;
    }

    public void run()
    {
      zzb.zzbd("LoadImageRunnable must be executed on the main thread");
      ImageManager.ImageReceiver localImageReceiver1 = (ImageManager.ImageReceiver)ImageManager.zza(ImageManager.this).get(this.zzOy);
      if (localImageReceiver1 != null)
      {
        ImageManager.zza(ImageManager.this).remove(this.zzOy);
        localImageReceiver1.zzc(this.zzOy);
      }
      zza.zza localzza = this.zzOy.zzOA;
      if (localzza.uri == null)
      {
        this.zzOy.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), true);
        return;
      }
      Bitmap localBitmap = ImageManager.zza(ImageManager.this, localzza);
      if (localBitmap != null)
      {
        this.zzOy.zza(ImageManager.zzb(ImageManager.this), localBitmap, true);
        return;
      }
      Long localLong = (Long)ImageManager.zzd(ImageManager.this).get(localzza.uri);
      if (localLong != null)
      {
        if (SystemClock.elapsedRealtime() - localLong.longValue() < 3600000L)
        {
          this.zzOy.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), true);
          return;
        }
        ImageManager.zzd(ImageManager.this).remove(localzza.uri);
      }
      this.zzOy.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this));
      ImageManager.ImageReceiver localImageReceiver2 = (ImageManager.ImageReceiver)ImageManager.zze(ImageManager.this).get(localzza.uri);
      if (localImageReceiver2 == null)
      {
        localImageReceiver2 = new ImageManager.ImageReceiver(ImageManager.this, localzza.uri);
        ImageManager.zze(ImageManager.this).put(localzza.uri, localImageReceiver2);
      }
      localImageReceiver2.zzb(this.zzOy);
      if (!(this.zzOy instanceof zza.zzc))
        ImageManager.zza(ImageManager.this).put(this.zzOy, localImageReceiver2);
      synchronized (ImageManager.zziF())
      {
        if (!ImageManager.zziG().contains(localzza.uri))
        {
          ImageManager.zziG().add(localzza.uri);
          localImageReceiver2.zziH();
        }
        return;
      }
    }
  }

  private static final class zze
    implements ComponentCallbacks2
  {
    private final ImageManager.zzb zzOq;

    public zze(ImageManager.zzb paramzzb)
    {
      this.zzOq = paramzzb;
    }

    public void onConfigurationChanged(Configuration paramConfiguration)
    {
    }

    public void onLowMemory()
    {
      this.zzOq.evictAll();
    }

    public void onTrimMemory(int paramInt)
    {
      if (paramInt >= 60)
        this.zzOq.evictAll();
      while (paramInt < 20)
        return;
      this.zzOq.trimToSize(this.zzOq.size() / 2);
    }
  }

  private final class zzf
    implements Runnable
  {
    private final Bitmap mBitmap;
    private final Uri mUri;
    private boolean zzOz;
    private final CountDownLatch zzmx;

    public zzf(Uri paramBitmap, Bitmap paramBoolean, boolean paramCountDownLatch, CountDownLatch arg5)
    {
      this.mUri = paramBitmap;
      this.mBitmap = paramBoolean;
      this.zzOz = paramCountDownLatch;
      Object localObject;
      this.zzmx = localObject;
    }

    private void zza(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
    {
      ArrayList localArrayList = ImageManager.ImageReceiver.zza(paramImageReceiver);
      int i = localArrayList.size();
      int j = 0;
      if (j < i)
      {
        zza localzza = (zza)localArrayList.get(j);
        if (paramBoolean)
          localzza.zza(ImageManager.zzb(ImageManager.this), this.mBitmap, false);
        while (true)
        {
          if (!(localzza instanceof zza.zzc))
            ImageManager.zza(ImageManager.this).remove(localzza);
          j++;
          break;
          ImageManager.zzd(ImageManager.this).put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
          localzza.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), false);
        }
      }
    }

    public void run()
    {
      zzb.zzbd("OnBitmapLoadedRunnable must be executed in the main thread");
      boolean bool;
      if (this.mBitmap != null)
        bool = true;
      while (ImageManager.zzh(ImageManager.this) != null)
        if (this.zzOz)
        {
          ImageManager.zzh(ImageManager.this).evictAll();
          System.gc();
          this.zzOz = false;
          ImageManager.zzg(ImageManager.this).post(this);
          return;
          bool = false;
        }
        else if (bool)
        {
          ImageManager.zzh(ImageManager.this).put(new zza.zza(this.mUri), this.mBitmap);
        }
      ImageManager.ImageReceiver localImageReceiver = (ImageManager.ImageReceiver)ImageManager.zze(ImageManager.this).remove(this.mUri);
      if (localImageReceiver != null)
        zza(localImageReceiver, bool);
      this.zzmx.countDown();
      synchronized (ImageManager.zziF())
      {
        ImageManager.zziG().remove(this.mUri);
        return;
      }
    }
  }
}