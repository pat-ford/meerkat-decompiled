package com.android.volley;

public class ServerError extends VolleyError
{
  public ServerError()
  {
  }

  public ServerError(NetworkResponse paramNetworkResponse)
  {
    super(paramNetworkResponse);
  }
}