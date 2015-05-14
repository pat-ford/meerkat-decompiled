package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

public abstract interface DriveFile extends DriveResource
{
  public static final int MODE_READ_ONLY = 268435456;
  public static final int MODE_READ_WRITE = 805306368;
  public static final int MODE_WRITE_ONLY = 536870912;

  public abstract PendingResult<DriveApi.DriveContentsResult> open(GoogleApiClient paramGoogleApiClient, int paramInt, DownloadProgressListener paramDownloadProgressListener);

  public static abstract interface DownloadProgressListener
  {
    public abstract void onProgress(long paramLong1, long paramLong2);
  }
}