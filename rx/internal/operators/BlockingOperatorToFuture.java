package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

public final class BlockingOperatorToFuture
{
  private BlockingOperatorToFuture()
  {
    throw new IllegalStateException("No instances!");
  }

  public static <T> Future<T> toFuture(Observable<? extends T> paramObservable)
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final AtomicReference localAtomicReference1 = new AtomicReference();
    final AtomicReference localAtomicReference2 = new AtomicReference();
    return new Future()
    {
      private volatile boolean cancelled = false;

      private T getValue()
        throws ExecutionException
      {
        if (localAtomicReference2.get() != null)
          throw new ExecutionException("Observable onError", (Throwable)localAtomicReference2.get());
        if (this.cancelled)
          throw new CancellationException("Subscription unsubscribed");
        return localAtomicReference1.get();
      }

      public boolean cancel(boolean paramAnonymousBoolean)
      {
        if (this.val$finished.getCount() > 0L)
        {
          this.cancelled = true;
          this.val$s.unsubscribe();
          this.val$finished.countDown();
          return true;
        }
        return false;
      }

      public T get()
        throws InterruptedException, ExecutionException
      {
        this.val$finished.await();
        return getValue();
      }

      public T get(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
        throws InterruptedException, ExecutionException, TimeoutException
      {
        if (this.val$finished.await(paramAnonymousLong, paramAnonymousTimeUnit))
          return getValue();
        throw new TimeoutException("Timed out after " + paramAnonymousTimeUnit.toMillis(paramAnonymousLong) + "ms waiting for underlying Observable.");
      }

      public boolean isCancelled()
      {
        return this.cancelled;
      }

      public boolean isDone()
      {
        return this.val$finished.getCount() == 0L;
      }
    };
  }
}