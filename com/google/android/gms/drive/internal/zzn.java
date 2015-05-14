package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzn
  implements Parcelable.Creator<DeleteResourceRequest>
{
  static void zza(DeleteResourceRequest paramDeleteResourceRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzK(paramParcel);
    zzb.zzc(paramParcel, 1, paramDeleteResourceRequest.zzFG);
    zzb.zza(paramParcel, 2, paramDeleteResourceRequest.zzTh, paramInt, false);
    zzb.zzH(paramParcel, i);
  }

  public DeleteResourceRequest zzas(Parcel paramParcel)
  {
    int i = zza.zzJ(paramParcel);
    int j = 0;
    DriveId localDriveId = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = zza.zzI(paramParcel);
      switch (zza.zzaP(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        j = zza.zzg(paramParcel, k);
        break;
      case 2:
        localDriveId = (DriveId)zza.zza(paramParcel, k, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new zza.zza("Overread allowed size end=" + i, paramParcel);
    return new DeleteResourceRequest(j, localDriveId);
  }

  public DeleteResourceRequest[] zzbH(int paramInt)
  {
    return new DeleteResourceRequest[paramInt];
  }
}