package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSortedMap<K, V> extends ForwardingMap<K, V>
  implements SortedMap<K, V>
{
  private int unsafeCompare(Object paramObject1, Object paramObject2)
  {
    Comparator localComparator = comparator();
    if (localComparator == null)
      return ((Comparable)paramObject1).compareTo(paramObject2);
    return localComparator.compare(paramObject1, paramObject2);
  }

  public Comparator<? super K> comparator()
  {
    return delegate().comparator();
  }

  protected abstract SortedMap<K, V> delegate();

  public K firstKey()
  {
    return delegate().firstKey();
  }

  public SortedMap<K, V> headMap(K paramK)
  {
    return delegate().headMap(paramK);
  }

  public K lastKey()
  {
    return delegate().lastKey();
  }

  @Beta
  protected boolean standardContainsKey(@Nullable Object paramObject)
  {
    try
    {
      int i = unsafeCompare(tailMap(paramObject).firstKey(), paramObject);
      boolean bool = false;
      if (i == 0)
        bool = true;
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      return false;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      return false;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    return false;
  }

  @Beta
  protected SortedMap<K, V> standardSubMap(K paramK1, K paramK2)
  {
    if (unsafeCompare(paramK1, paramK2) <= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "fromKey must be <= toKey");
      return tailMap(paramK1).headMap(paramK2);
    }
  }

  public SortedMap<K, V> subMap(K paramK1, K paramK2)
  {
    return delegate().subMap(paramK1, paramK2);
  }

  public SortedMap<K, V> tailMap(K paramK)
  {
    return delegate().tailMap(paramK);
  }

  @Beta
  protected class StandardKeySet extends Maps.SortedKeySet<K, V>
  {
    public StandardKeySet()
    {
      super();
    }
  }
}