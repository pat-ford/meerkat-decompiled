package android.support.v4.view;

import android.view.LayoutInflater;

class LayoutInflaterCompatLollipop
{
  static void setFactory(LayoutInflater paramLayoutInflater, LayoutInflaterFactory paramLayoutInflaterFactory)
  {
    if (paramLayoutInflaterFactory != null);
    for (LayoutInflaterCompatHC.FactoryWrapperHC localFactoryWrapperHC = new LayoutInflaterCompatHC.FactoryWrapperHC(paramLayoutInflaterFactory); ; localFactoryWrapperHC = null)
    {
      paramLayoutInflater.setFactory2(localFactoryWrapperHC);
      return;
    }
  }
}