package retrofit;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

final class Utils
{
  private static final int BUFFER_SIZE = 4096;

  static Request readBodyToBytesIfNecessary(Request paramRequest)
    throws IOException
  {
    TypedOutput localTypedOutput = paramRequest.getBody();
    if ((localTypedOutput == null) || ((localTypedOutput instanceof TypedByteArray)))
      return paramRequest;
    String str = localTypedOutput.mimeType();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    localTypedOutput.writeTo(localByteArrayOutputStream);
    TypedByteArray localTypedByteArray = new TypedByteArray(str, localByteArrayOutputStream.toByteArray());
    return new Request(paramRequest.getMethod(), paramRequest.getUrl(), paramRequest.getHeaders(), localTypedByteArray);
  }

  // ERROR //
  static Response readBodyToBytesIfNecessary(Response paramResponse)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 62\011retrofit/client/Response:getBody\011()Lretrofit/mime/TypedInput;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +10 -> 16
    //   9: aload_1
    //   10: instanceof 23
    //   13: ifeq +5 -> 18
    //   16: aload_0
    //   17: areturn
    //   18: aload_1
    //   19: invokeinterface 65 1 0
    //   24: astore_2
    //   25: aload_1
    //   26: invokeinterface 69 1 0
    //   31: astore_3
    //   32: new 23\011retrofit/mime/TypedByteArray
    //   35: dup
    //   36: aload_2
    //   37: aload_3
    //   38: invokestatic 73\011retrofit/Utils:streamToBytes\011(Ljava/io/InputStream;)[B
    //   41: invokespecial 43\011retrofit/mime/TypedByteArray:<init>\011(Ljava/lang/String;[B)V
    //   44: astore 4
    //   46: aload_0
    //   47: aload 4
    //   49: invokestatic 77\011retrofit/Utils:replaceResponseBody\011(Lretrofit/client/Response;Lretrofit/mime/TypedInput;)Lretrofit/client/Response;
    //   52: astore 7
    //   54: aload_3
    //   55: ifnull +7 -> 62
    //   58: aload_3
    //   59: invokevirtual 82\011java/io/InputStream:close\011()V
    //   62: aload 7
    //   64: areturn
    //   65: astore 5
    //   67: aload_3
    //   68: ifnull +7 -> 75
    //   71: aload_3
    //   72: invokevirtual 82\011java/io/InputStream:close\011()V
    //   75: aload 5
    //   77: athrow
    //   78: astore 8
    //   80: goto -18 -> 62
    //   83: astore 6
    //   85: goto -10 -> 75
    //   88: astore 5
    //   90: goto -23 -> 67
    //
    // Exception table:
    //   from\011to\011target\011type
    //   32\01146\01165\011finally
    //   58\01162\01178\011java/io/IOException
    //   71\01175\01183\011java/io/IOException
    //   46\01154\01188\011finally
  }

  static Response replaceResponseBody(Response paramResponse, TypedInput paramTypedInput)
  {
    return new Response(paramResponse.getUrl(), paramResponse.getStatus(), paramResponse.getReason(), paramResponse.getHeaders(), paramTypedInput);
  }

  static byte[] streamToBytes(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    if (paramInputStream != null)
    {
      byte[] arrayOfByte = new byte[4096];
      while (true)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1)
          break;
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
    }
    return localByteArrayOutputStream.toByteArray();
  }

  static <T> void validateServiceClass(Class<T> paramClass)
  {
    if (!paramClass.isInterface())
      throw new IllegalArgumentException("Only interface endpoint definitions are supported.");
    if (paramClass.getInterfaces().length > 0)
      throw new IllegalArgumentException("Interface definitions must not extend other interfaces.");
  }

  static class SynchronousExecutor
    implements Executor
  {
    public void execute(Runnable paramRunnable)
    {
      paramRunnable.run();
    }
  }
}