package android.support.v4.view;

import android.view.MenuItem;

public class MenuCompat
{
  @Deprecated
  public static void setShowAsAction(MenuItem paramMenuItem, int paramInt)
  {
    MenuItemCompat.setShowAsAction(paramMenuItem, paramInt);
  }
}