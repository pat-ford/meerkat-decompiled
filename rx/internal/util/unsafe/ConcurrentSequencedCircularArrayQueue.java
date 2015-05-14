package rx.internal.util.unsafe;

import sun.misc.Unsafe;

public abstract class ConcurrentSequencedCircularArrayQueue<E> extends ConcurrentCircularArrayQueue<E>
{
  private static final long ARRAY_BASE;
  private static final int ELEMENT_SHIFT;
  protected final long[] sequenceBuffer;

  static
  {
    if (8 == UnsafeAccess.UNSAFE.arrayIndexScale([J.class))
    {
      ELEMENT_SHIFT = 3 + SPARSE_SHIFT;
      ARRAY_BASE = UnsafeAccess.UNSAFE.arrayBaseOffset([J.class) + (32 << ELEMENT_SHIFT - SPARSE_SHIFT);
      return;
    }
    throw new IllegalStateException("Unexpected long[] element size");
  }

  public ConcurrentSequencedCircularArrayQueue(int paramInt)
  {
    super(paramInt);
    int i = (int)(1L + this.mask);
    this.sequenceBuffer = new long[64 + (i << SPARSE_SHIFT)];
    for (long l = 0L; l < i; l += 1L)
      soSequence(this.sequenceBuffer, calcSequenceOffset(l), l);
  }

  protected final long calcSequenceOffset(long paramLong)
  {
    return ARRAY_BASE + ((paramLong & this.mask) << ELEMENT_SHIFT);
  }

  protected final long lvSequence(long[] paramArrayOfLong, long paramLong)
  {
    return UnsafeAccess.UNSAFE.getLongVolatile(paramArrayOfLong, paramLong);
  }

  protected final void soSequence(long[] paramArrayOfLong, long paramLong1, long paramLong2)
  {
    UnsafeAccess.UNSAFE.putOrderedLong(paramArrayOfLong, paramLong1, paramLong2);
  }
}