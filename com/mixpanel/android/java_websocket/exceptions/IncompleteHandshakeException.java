package com.mixpanel.android.java_websocket.exceptions;

public class IncompleteHandshakeException extends RuntimeException
{
  private static final long serialVersionUID = 7906596804233893092L;
  private int newsize;

  public IncompleteHandshakeException()
  {
    this.newsize = 0;
  }

  public IncompleteHandshakeException(int paramInt)
  {
    this.newsize = paramInt;
  }

  public int getPreferedSize()
  {
    return this.newsize;
  }
}