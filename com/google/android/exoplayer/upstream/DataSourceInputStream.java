package com.google.android.exoplayer.upstream;

import com.google.android.exoplayer.util.Assertions;
import java.io.IOException;
import java.io.InputStream;

public class DataSourceInputStream extends InputStream
{
  private boolean closed = false;
  private final DataSource dataSource;
  private final DataSpec dataSpec;
  private boolean opened = false;
  private final byte[] singleByteArray;

  public DataSourceInputStream(DataSource paramDataSource, DataSpec paramDataSpec)
  {
    this.dataSource = paramDataSource;
    this.dataSpec = paramDataSpec;
    this.singleByteArray = new byte[1];
  }

  private void checkOpened()
    throws IOException
  {
    if (!this.opened)
    {
      this.dataSource.open(this.dataSpec);
      this.opened = true;
    }
  }

  public void close()
    throws IOException
  {
    if (!this.closed)
    {
      this.dataSource.close();
      this.closed = true;
    }
  }

  public int read()
    throws IOException
  {
    read(this.singleByteArray);
    return 0xFF & this.singleByteArray[0];
  }

  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (!this.closed);
    for (boolean bool = true; ; bool = false)
    {
      Assertions.checkState(bool);
      checkOpened();
      return this.dataSource.read(paramArrayOfByte, paramInt1, paramInt2);
    }
  }

  public long skip(long paramLong)
    throws IOException
  {
    if (!this.closed);
    for (boolean bool = true; ; bool = false)
    {
      Assertions.checkState(bool);
      checkOpened();
      return super.skip(paramLong);
    }
  }
}