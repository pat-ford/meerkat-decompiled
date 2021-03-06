package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class FetchThumbnailRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<FetchThumbnailRequest> CREATOR = new zzab();
  final int zzFG;
  final DriveId zzTh;

  FetchThumbnailRequest(int paramInt, DriveId paramDriveId)
  {
    this.zzFG = paramInt;
    this.zzTh = paramDriveId;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzab.zza(this, paramParcel, paramInt);
  }
}