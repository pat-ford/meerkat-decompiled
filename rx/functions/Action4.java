package rx.functions;

public abstract interface Action4<T1, T2, T3, T4> extends Action
{
  public abstract void call(T1 paramT1, T2 paramT2, T3 paramT3, T4 paramT4);
}