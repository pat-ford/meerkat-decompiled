package com.google.ads;

public enum AdRequest$ErrorCode
{
  private final String description;

  static
  {
    NETWORK_ERROR = new ErrorCode("NETWORK_ERROR", 2, "A network error occurred.");
    INTERNAL_ERROR = new ErrorCode("INTERNAL_ERROR", 3, "There was an internal error.");
    ErrorCode[] arrayOfErrorCode = new ErrorCode[4];
    arrayOfErrorCode[0] = INVALID_REQUEST;
    arrayOfErrorCode[1] = NO_FILL;
    arrayOfErrorCode[2] = NETWORK_ERROR;
    arrayOfErrorCode[3] = INTERNAL_ERROR;
  }

  private AdRequest$ErrorCode(String paramString)
  {
    this.description = paramString;
  }

  public String toString()
  {
    return this.description;
  }
}