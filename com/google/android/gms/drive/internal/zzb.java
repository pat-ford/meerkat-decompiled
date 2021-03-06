package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.drive.DriveId;

public class zzb
  implements Parcelable.Creator<AuthorizeAccessRequest>
{
  static void zza(AuthorizeAccessRequest paramAuthorizeAccessRequest, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzK(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramAuthorizeAccessRequest.zzFG);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramAuthorizeAccessRequest.zzTf);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramAuthorizeAccessRequest.zzRX, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzH(paramParcel, i);
  }

  public AuthorizeAccessRequest zzaj(Parcel paramParcel)
  {
    int i = zza.zzJ(paramParcel);
    int j = 0;
    long l = 0L;
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
        l = zza.zzi(paramParcel, k);
        break;
      case 3:
        localDriveId = (DriveId)zza.zza(paramParcel, k, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new zza.zza("Overread allowed size end=" + i, paramParcel);
    return new AuthorizeAccessRequest(j, l, localDriveId);
  }

  public AuthorizeAccessRequest[] zzbx(int paramInt)
  {
    return new AuthorizeAccessRequest[paramInt];
  }
}