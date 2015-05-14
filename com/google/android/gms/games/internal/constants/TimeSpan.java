package com.google.android.gms.games.internal.constants;

public final class TimeSpan
{
  private TimeSpan()
  {
    throw new AssertionError("Uninstantiable");
  }

  public static String zzeJ(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown time span " + paramInt);
    case 0:
      return "DAILY";
    case 1:
      return "WEEKLY";
    case 2:
    }
    return "ALL_TIME";
  }
}