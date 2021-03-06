package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<WebImage>
{
  static void zza(WebImage paramWebImage, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzK(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramWebImage.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramWebImage.getUrl(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 3, paramWebImage.getWidth());
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 4, paramWebImage.getHeight());
    com.google.android.gms.common.internal.safeparcel.zzb.zzH(paramParcel, i);
  }

  public WebImage zzB(Parcel paramParcel)
  {
    int i = 0;
    int j = zza.zzJ(paramParcel);
    Object localObject1 = null;
    int k = 0;
    int m = 0;
    if (paramParcel.dataPosition() < j)
    {
      int n = zza.zzI(paramParcel);
      int i1;
      int i2;
      Object localObject2;
      int i3;
      switch (zza.zzaP(n))
      {
      default:
        zza.zzb(paramParcel, n);
        i1 = i;
        i2 = k;
        localObject2 = localObject1;
        i3 = m;
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        m = i3;
        localObject1 = localObject2;
        k = i2;
        i = i1;
        break;
        int i7 = zza.zzg(paramParcel, n);
        int i8 = i;
        i2 = k;
        localObject2 = localObject1;
        i3 = i7;
        i1 = i8;
        continue;
        Uri localUri = (Uri)zza.zza(paramParcel, n, Uri.CREATOR);
        i3 = m;
        int i6 = k;
        localObject2 = localUri;
        i1 = i;
        i2 = i6;
        continue;
        int i4 = zza.zzg(paramParcel, n);
        localObject2 = localObject1;
        i3 = m;
        int i5 = i;
        i2 = i4;
        i1 = i5;
        continue;
        i1 = zza.zzg(paramParcel, n);
        i2 = k;
        localObject2 = localObject1;
        i3 = m;
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new WebImage(m, localObject1, k, i);
  }

  public WebImage[] zzaD(int paramInt)
  {
    return new WebImage[paramInt];
  }
}