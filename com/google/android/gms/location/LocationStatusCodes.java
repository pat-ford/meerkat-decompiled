package com.google.android.gms.location;

import com.google.android.gms.common.api.Status;

@Deprecated
public final class LocationStatusCodes
{
  public static final int ERROR = 1;
  public static final int GEOFENCE_NOT_AVAILABLE = 1000;
  public static final int GEOFENCE_TOO_MANY_GEOFENCES = 1001;
  public static final int GEOFENCE_TOO_MANY_PENDING_INTENTS = 1002;
  public static final int SUCCESS;

  public static int zzfq(int paramInt)
  {
    if (((paramInt >= 0) && (paramInt <= 1)) || ((1000 <= paramInt) && (paramInt <= 1002)))
      return paramInt;
    return 1;
  }

  public static Status zzfr(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 1:
    }
    while (true)
    {
      return new Status(paramInt);
      paramInt = 13;
    }
  }
}