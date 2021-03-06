package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@Beta
public final class Closeables
{

  @VisibleForTesting
  static final Logger logger = Logger.getLogger(Closeables.class.getName());

  public static void close(@Nullable Closeable paramCloseable, boolean paramBoolean)
    throws IOException
  {
    if (paramCloseable == null)
      return;
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
      if (paramBoolean)
      {
        logger.log(Level.WARNING, "IOException thrown while closing Closeable.", localIOException);
        return;
      }
      throw localIOException;
    }
  }

  public static void closeQuietly(@Nullable InputStream paramInputStream)
  {
    try
    {
      close(paramInputStream, true);
      return;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }

  public static void closeQuietly(@Nullable Reader paramReader)
  {
    try
    {
      close(paramReader, true);
      return;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }
}