package com.instabug.library;

import android.os.AsyncTask;
import java.io.File;

final class s extends AsyncTask
{
  s(q paramq)
  {
  }

  private static Void a(File[] paramArrayOfFile)
  {
    try
    {
      paramArrayOfFile[0].delete();
      label7: return null;
    }
    catch (Exception localException)
    {
      break label7;
    }
  }
}