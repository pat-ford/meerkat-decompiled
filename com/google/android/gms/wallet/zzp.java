package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzp
  implements Parcelable.Creator<ProxyCard>
{
  static void zza(ProxyCard paramProxyCard, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzK(paramParcel);
    zzb.zzc(paramParcel, 1, paramProxyCard.getVersionCode());
    zzb.zza(paramParcel, 2, paramProxyCard.zzaEi, false);
    zzb.zza(paramParcel, 3, paramProxyCard.zzaEj, false);
    zzb.zzc(paramParcel, 4, paramProxyCard.zzaEk);
    zzb.zzc(paramParcel, 5, paramProxyCard.zzaEl);
    zzb.zzH(paramParcel, i);
  }

  public ProxyCard zzfc(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int j = zza.zzJ(paramParcel);
    int k = 0;
    String str2 = null;
    int m = 0;
    while (paramParcel.dataPosition() < j)
    {
      int n = zza.zzI(paramParcel);
      switch (zza.zzaP(n))
      {
      default:
        zza.zzb(paramParcel, n);
        break;
      case 1:
        m = zza.zzg(paramParcel, n);
        break;
      case 2:
        str2 = zza.zzo(paramParcel, n);
        break;
      case 3:
        str1 = zza.zzo(paramParcel, n);
        break;
      case 4:
        k = zza.zzg(paramParcel, n);
        break;
      case 5:
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new ProxyCard(m, str2, str1, k, i);
  }

  public ProxyCard[] zzhz(int paramInt)
  {
    return new ProxyCard[paramInt];
  }
}