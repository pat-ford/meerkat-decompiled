package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.zza.zza;
import com.google.android.gms.safetynet.SafetyNet;

abstract class zzuj<R extends Result> extends zza.zza<R, zzun>
{
  public zzuj(GoogleApiClient paramGoogleApiClient)
  {
    super(SafetyNet.zzGR, paramGoogleApiClient);
  }
}