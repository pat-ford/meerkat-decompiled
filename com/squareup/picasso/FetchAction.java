package com.squareup.picasso;

import android.graphics.Bitmap;

class FetchAction extends Action<Void>
{
  FetchAction(Picasso paramPicasso, Request paramRequest, boolean paramBoolean, String paramString)
  {
    super(paramPicasso, null, paramRequest, paramBoolean, false, 0, null, paramString);
  }

  void complete(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom)
  {
  }

  public void error()
  {
  }
}