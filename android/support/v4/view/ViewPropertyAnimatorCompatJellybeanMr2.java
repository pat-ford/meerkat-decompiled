package android.support.v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

class ViewPropertyAnimatorCompatJellybeanMr2
{
  public static Interpolator getInterpolator(View paramView)
  {
    return (Interpolator)paramView.animate().getInterpolator();
  }
}