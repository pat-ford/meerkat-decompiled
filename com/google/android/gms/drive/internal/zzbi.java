package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DrivePreferences;

public class zzbi
  implements Parcelable.Creator<SetDrivePreferencesRequest>
{
  static void zza(SetDrivePreferencesRequest paramSetDrivePreferencesRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzK(paramParcel);
    zzb.zzc(paramParcel, 1, paramSetDrivePreferencesRequest.zzFG);
    zzb.zza(paramParcel, 2, paramSetDrivePreferencesRequest.zzUT, paramInt, false);
    zzb.zzH(paramParcel, i);
  }

  public SetDrivePreferencesRequest zzaU(Parcel paramParcel)
  {
    int i = zza.zzJ(paramParcel);
    int j = 0;
    DrivePreferences localDrivePreferences = null;
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
        localDrivePreferences = (DrivePreferences)zza.zza(paramParcel, k, DrivePreferences.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new zza.zza("Overread allowed size end=" + i, paramParcel);
    return new SetDrivePreferencesRequest(j, localDrivePreferences);
  }

  public SetDrivePreferencesRequest[] zzcn(int paramInt)
  {
    return new SetDrivePreferencesRequest[paramInt];
  }
}