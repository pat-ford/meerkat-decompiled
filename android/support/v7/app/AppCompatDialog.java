package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.ActionMode;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class AppCompatDialog extends Dialog
  implements AppCompatCallback
{
  private AppCompatDelegate mDelegate;

  public AppCompatDialog(Context paramContext)
  {
    this(paramContext, 0);
  }

  public AppCompatDialog(Context paramContext, int paramInt)
  {
    super(paramContext, getThemeResId(paramContext, paramInt));
    getDelegate().onCreate(null);
  }

  protected AppCompatDialog(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
  }

  private static int getThemeResId(Context paramContext, int paramInt)
  {
    if (paramInt == 0)
    {
      TypedValue localTypedValue = new TypedValue();
      paramContext.getTheme().resolveAttribute(R.attr.dialogTheme, localTypedValue, true);
      paramInt = localTypedValue.resourceId;
    }
    return paramInt;
  }

  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().addContentView(paramView, paramLayoutParams);
  }

  public AppCompatDelegate getDelegate()
  {
    if (this.mDelegate == null)
      this.mDelegate = AppCompatDelegate.create(this, this);
    return this.mDelegate;
  }

  public ActionBar getSupportActionBar()
  {
    return getDelegate().getSupportActionBar();
  }

  public void invalidateOptionsMenu()
  {
    getDelegate().invalidateOptionsMenu();
  }

  protected void onCreate(Bundle paramBundle)
  {
    getDelegate().installViewFactory();
    super.onCreate(paramBundle);
    getDelegate().onCreate(paramBundle);
  }

  protected void onStop()
  {
    super.onStop();
    getDelegate().onStop();
  }

  public void onSupportActionModeFinished(ActionMode paramActionMode)
  {
  }

  public void onSupportActionModeStarted(ActionMode paramActionMode)
  {
  }

  public void setContentView(int paramInt)
  {
    getDelegate().setContentView(paramInt);
  }

  public void setContentView(View paramView)
  {
    getDelegate().setContentView(paramView);
  }

  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().setContentView(paramView, paramLayoutParams);
  }

  public void setTitle(int paramInt)
  {
    super.setTitle(paramInt);
    getDelegate().setTitle(getContext().getString(paramInt));
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    getDelegate().setTitle(paramCharSequence);
  }

  public boolean supportRequestWindowFeature(int paramInt)
  {
    return getDelegate().requestWindowFeature(paramInt);
  }
}