package retrofit;

public abstract interface ErrorHandler
{
  public static final ErrorHandler DEFAULT = new ErrorHandler()
  {
    public Throwable handleError(RetrofitError paramAnonymousRetrofitError)
    {
      return paramAnonymousRetrofitError;
    }
  };

  public abstract Throwable handleError(RetrofitError paramRetrofitError);
}