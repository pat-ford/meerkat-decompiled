package rx.functions;

public abstract interface Action3<T1, T2, T3> extends Action
{
  public abstract void call(T1 paramT1, T2 paramT2, T3 paramT3);
}