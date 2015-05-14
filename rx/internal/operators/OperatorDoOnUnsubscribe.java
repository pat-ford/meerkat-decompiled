package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

public class OperatorDoOnUnsubscribe<T>
  implements Observable.Operator<T, T>
{
  private final Action0 unsubscribe;

  public OperatorDoOnUnsubscribe(Action0 paramAction0)
  {
    this.unsubscribe = paramAction0;
  }

  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    paramSubscriber.add(Subscriptions.create(this.unsubscribe));
    return paramSubscriber;
  }
}