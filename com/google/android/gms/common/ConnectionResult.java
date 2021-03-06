package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public final class ConnectionResult
  implements SafeParcelable
{
  public static final int API_UNAVAILABLE = 16;
  public static final int CANCELED = 13;
  public static final ConnectionResultCreator CREATOR = new ConnectionResultCreator();
  public static final int DEVELOPER_ERROR = 10;

  @Deprecated
  public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
  public static final int INTERNAL_ERROR = 8;
  public static final int INTERRUPTED = 15;
  public static final int INVALID_ACCOUNT = 5;
  public static final int LICENSE_CHECK_FAILED = 11;
  public static final int NETWORK_ERROR = 7;
  public static final int RESOLUTION_REQUIRED = 6;
  public static final int SERVICE_DISABLED = 3;
  public static final int SERVICE_INVALID = 9;
  public static final int SERVICE_MISSING = 1;
  public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
  public static final int SIGN_IN_FAILED = 17;
  public static final int SIGN_IN_REQUIRED = 4;
  public static final int SUCCESS = 0;
  public static final int TIMEOUT = 14;
  public static final ConnectionResult zzLr = new ConnectionResult(0, null);
  private final PendingIntent mPendingIntent;
  final int zzFG;
  private final int zzLs;

  ConnectionResult(int paramInt1, int paramInt2, PendingIntent paramPendingIntent)
  {
    this.zzFG = paramInt1;
    this.zzLs = paramInt2;
    this.mPendingIntent = paramPendingIntent;
  }

  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramPendingIntent);
  }

  private String zzhK()
  {
    switch (this.zzLs)
    {
    case 12:
    default:
      return "unknown status code " + this.zzLs;
    case 0:
      return "SUCCESS";
    case 1:
      return "SERVICE_MISSING";
    case 2:
      return "SERVICE_VERSION_UPDATE_REQUIRED";
    case 3:
      return "SERVICE_DISABLED";
    case 4:
      return "SIGN_IN_REQUIRED";
    case 5:
      return "INVALID_ACCOUNT";
    case 6:
      return "RESOLUTION_REQUIRED";
    case 7:
      return "NETWORK_ERROR";
    case 8:
      return "INTERNAL_ERROR";
    case 9:
      return "SERVICE_INVALID";
    case 10:
      return "DEVELOPER_ERROR";
    case 11:
      return "LICENSE_CHECK_FAILED";
    case 13:
      return "CANCELED";
    case 14:
      return "TIMEOUT";
    case 15:
      return "INTERRUPTED";
    case 16:
      return "API_UNAVAILABLE";
    case 17:
    }
    return "SIGN_IN_FAILED";
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    ConnectionResult localConnectionResult;
    do
    {
      return true;
      if (!(paramObject instanceof ConnectionResult))
        return false;
      localConnectionResult = (ConnectionResult)paramObject;
    }
    while ((this.zzLs == localConnectionResult.zzLs) && (zzw.equal(this.mPendingIntent, localConnectionResult.mPendingIntent)));
    return false;
  }

  public int getErrorCode()
  {
    return this.zzLs;
  }

  public PendingIntent getResolution()
  {
    return this.mPendingIntent;
  }

  public boolean hasResolution()
  {
    return (this.zzLs != 0) && (this.mPendingIntent != null);
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.zzLs);
    arrayOfObject[1] = this.mPendingIntent;
    return zzw.hashCode(arrayOfObject);
  }

  public boolean isSuccess()
  {
    return this.zzLs == 0;
  }

  public void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    if (!hasResolution())
      return;
    paramActivity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
  }

  public String toString()
  {
    return zzw.zzk(this).zza("statusCode", zzhK()).zza("resolution", this.mPendingIntent).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ConnectionResultCreator.zza(this, paramParcel, paramInt);
  }
}