package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class TintImageView extends ImageView
{
  private static final int[] TINT_ATTRS = { 16842964, 16843033 };
  private final TintManager mTintManager;

  public TintImageView(Context paramContext)
  {
    this(paramContext, null);
  }

  public TintImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public TintImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, TINT_ATTRS, paramInt, 0);
    if (localTintTypedArray.length() > 0)
    {
      if (localTintTypedArray.hasValue(0))
        setBackgroundDrawable(localTintTypedArray.getDrawable(0));
      if (localTintTypedArray.hasValue(1))
        setImageDrawable(localTintTypedArray.getDrawable(1));
    }
    localTintTypedArray.recycle();
    this.mTintManager = localTintTypedArray.getTintManager();
  }

  public void setImageResource(int paramInt)
  {
    setImageDrawable(this.mTintManager.getDrawable(paramInt));
  }
}