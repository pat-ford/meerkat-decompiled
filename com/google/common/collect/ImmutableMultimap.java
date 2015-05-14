package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public abstract class ImmutableMultimap<K, V> extends AbstractMultimap<K, V>
  implements Serializable
{
  private static final long serialVersionUID;
  final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
  final transient int size;

  ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> paramImmutableMap, int paramInt)
  {
    this.map = paramImmutableMap;
    this.size = paramInt;
  }

  public static <K, V> Builder<K, V> builder()
  {
    return new Builder();
  }

  public static <K, V> ImmutableMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> paramMultimap)
  {
    if ((paramMultimap instanceof ImmutableMultimap))
    {
      ImmutableMultimap localImmutableMultimap = (ImmutableMultimap)paramMultimap;
      if (!localImmutableMultimap.isPartialView())
        return localImmutableMultimap;
    }
    return ImmutableListMultimap.copyOf(paramMultimap);
  }

  public static <K, V> ImmutableMultimap<K, V> of()
  {
    return ImmutableListMultimap.of();
  }

  public static <K, V> ImmutableMultimap<K, V> of(K paramK, V paramV)
  {
    return ImmutableListMultimap.of(paramK, paramV);
  }

  public static <K, V> ImmutableMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    return ImmutableListMultimap.of(paramK1, paramV1, paramK2, paramV2);
  }

  public static <K, V> ImmutableMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    return ImmutableListMultimap.of(paramK1, paramV1, paramK2, paramV2, paramK3, paramV3);
  }

  public static <K, V> ImmutableMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    return ImmutableListMultimap.of(paramK1, paramV1, paramK2, paramV2, paramK3, paramV3, paramK4, paramV4);
  }

  public static <K, V> ImmutableMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    return ImmutableListMultimap.of(paramK1, paramV1, paramK2, paramV2, paramK3, paramV3, paramK4, paramV4, paramK5, paramV5);
  }

  public ImmutableMap<K, Collection<V>> asMap()
  {
    return this.map;
  }

  @Deprecated
  public void clear()
  {
    throw new UnsupportedOperationException();
  }

  public boolean containsKey(@Nullable Object paramObject)
  {
    return this.map.containsKey(paramObject);
  }

  public boolean containsValue(@Nullable Object paramObject)
  {
    return (paramObject != null) && (super.containsValue(paramObject));
  }

  Map<K, Collection<V>> createAsMap()
  {
    throw new AssertionError("should never be called");
  }

  ImmutableCollection<Map.Entry<K, V>> createEntries()
  {
    return new EntryCollection(this);
  }

  ImmutableMultiset<K> createKeys()
  {
    return new Keys();
  }

  ImmutableCollection<V> createValues()
  {
    return new Values(this);
  }

  public ImmutableCollection<Map.Entry<K, V>> entries()
  {
    return (ImmutableCollection)super.entries();
  }

  UnmodifiableIterator<Map.Entry<K, V>> entryIterator()
  {
    // Byte code:
    //   0: new 134\011com/google/common/collect/ImmutableMultimap$1
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 135\011com/google/common/collect/ImmutableMultimap$1:<init>\011(Lcom/google/common/collect/ImmutableMultimap;)V
    //   8: areturn
  }

  public abstract ImmutableCollection<V> get(K paramK);

  public abstract ImmutableMultimap<V, K> inverse();

  boolean isPartialView()
  {
    return this.map.isPartialView();
  }

  public ImmutableSet<K> keySet()
  {
    return this.map.keySet();
  }

  public ImmutableMultiset<K> keys()
  {
    return (ImmutableMultiset)super.keys();
  }

  @Deprecated
  public boolean put(K paramK, V paramV)
  {
    throw new UnsupportedOperationException();
  }

  @Deprecated
  public boolean putAll(Multimap<? extends K, ? extends V> paramMultimap)
  {
    throw new UnsupportedOperationException();
  }

  @Deprecated
  public boolean putAll(K paramK, Iterable<? extends V> paramIterable)
  {
    throw new UnsupportedOperationException();
  }

  @Deprecated
  public boolean remove(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException();
  }

  @Deprecated
  public ImmutableCollection<V> removeAll(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }

  @Deprecated
  public ImmutableCollection<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
  {
    throw new UnsupportedOperationException();
  }

  public int size()
  {
    return this.size;
  }

  UnmodifiableIterator<V> valueIterator()
  {
    // Byte code:
    //   0: new 188\011com/google/common/collect/ImmutableMultimap$2
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 189\011com/google/common/collect/ImmutableMultimap$2:<init>\011(Lcom/google/common/collect/ImmutableMultimap;)V
    //   8: areturn
  }

  public ImmutableCollection<V> values()
  {
    return (ImmutableCollection)super.values();
  }

  public static class Builder<K, V>
  {
    Multimap<K, V> builderMultimap = new ImmutableMultimap.BuilderMultimap();
    Comparator<? super K> keyComparator;
    Comparator<? super V> valueComparator;

    public ImmutableMultimap<K, V> build()
    {
      if (this.valueComparator != null)
      {
        Iterator localIterator2 = this.builderMultimap.asMap().values().iterator();
        while (localIterator2.hasNext())
          Collections.sort((List)localIterator2.next(), this.valueComparator);
      }
      if (this.keyComparator != null)
      {
        ImmutableMultimap.BuilderMultimap localBuilderMultimap = new ImmutableMultimap.BuilderMultimap();
        ArrayList localArrayList = Lists.newArrayList(this.builderMultimap.asMap().entrySet());
        Collections.sort(localArrayList, Ordering.from(this.keyComparator).onKeys());
        Iterator localIterator1 = localArrayList.iterator();
        while (localIterator1.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator1.next();
          localBuilderMultimap.putAll(localEntry.getKey(), (Iterable)localEntry.getValue());
        }
        this.builderMultimap = localBuilderMultimap;
      }
      return ImmutableMultimap.copyOf(this.builderMultimap);
    }

    public Builder<K, V> orderKeysBy(Comparator<? super K> paramComparator)
    {
      this.keyComparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
      return this;
    }

    public Builder<K, V> orderValuesBy(Comparator<? super V> paramComparator)
    {
      this.valueComparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
      return this;
    }

    public Builder<K, V> put(K paramK, V paramV)
    {
      CollectPreconditions.checkEntryNotNull(paramK, paramV);
      this.builderMultimap.put(paramK, paramV);
      return this;
    }

    public Builder<K, V> put(Map.Entry<? extends K, ? extends V> paramEntry)
    {
      return put(paramEntry.getKey(), paramEntry.getValue());
    }

    public Builder<K, V> putAll(Multimap<? extends K, ? extends V> paramMultimap)
    {
      Iterator localIterator = paramMultimap.asMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        putAll(localEntry.getKey(), (Iterable)localEntry.getValue());
      }
      return this;
    }

    public Builder<K, V> putAll(K paramK, Iterable<? extends V> paramIterable)
    {
      if (paramK == null)
      {
        String str1 = String.valueOf(Iterables.toString(paramIterable));
        if (str1.length() != 0);
        for (String str2 = "null key in entry: null=".concat(str1); ; str2 = new String("null key in entry: null="))
          throw new NullPointerException(str2);
      }
      Collection localCollection = this.builderMultimap.get(paramK);
      Iterator localIterator = paramIterable.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        CollectPreconditions.checkEntryNotNull(paramK, localObject);
        localCollection.add(localObject);
      }
      return this;
    }

    public Builder<K, V> putAll(K paramK, V[] paramArrayOfV)
    {
      return putAll(paramK, Arrays.asList(paramArrayOfV));
    }
  }

  private static class BuilderMultimap<K, V> extends AbstractMapBasedMultimap<K, V>
  {
    private static final long serialVersionUID;

    BuilderMultimap()
    {
      super();
    }

    Collection<V> createCollection()
    {
      return Lists.newArrayList();
    }
  }

  private static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>>
  {
    private static final long serialVersionUID;
    final ImmutableMultimap<K, V> multimap;

    EntryCollection(ImmutableMultimap<K, V> paramImmutableMultimap)
    {
      this.multimap = paramImmutableMultimap;
    }

    public boolean contains(Object paramObject)
    {
      if ((paramObject instanceof Map.Entry))
      {
        Map.Entry localEntry = (Map.Entry)paramObject;
        return this.multimap.containsEntry(localEntry.getKey(), localEntry.getValue());
      }
      return false;
    }

    boolean isPartialView()
    {
      return this.multimap.isPartialView();
    }

    public UnmodifiableIterator<Map.Entry<K, V>> iterator()
    {
      return this.multimap.entryIterator();
    }

    public int size()
    {
      return this.multimap.size();
    }
  }

  @GwtIncompatible("java serialization is not supported")
  static class FieldSettersHolder
  {
    static final Serialization.FieldSetter<ImmutableSetMultimap> EMPTY_SET_FIELD_SETTER = Serialization.getFieldSetter(ImmutableSetMultimap.class, "emptySet");
    static final Serialization.FieldSetter<ImmutableMultimap> MAP_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "map");
    static final Serialization.FieldSetter<ImmutableMultimap> SIZE_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "size");
  }

  private abstract class Itr<T> extends UnmodifiableIterator<T>
  {
    K key = null;
    final Iterator<Map.Entry<K, Collection<V>>> mapIterator = ImmutableMultimap.this.asMap().entrySet().iterator();
    Iterator<V> valueIterator = Iterators.emptyIterator();

    private Itr()
    {
    }

    public boolean hasNext()
    {
      return (this.mapIterator.hasNext()) || (this.valueIterator.hasNext());
    }

    public T next()
    {
      if (!this.valueIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)this.mapIterator.next();
        this.key = localEntry.getKey();
        this.valueIterator = ((Collection)localEntry.getValue()).iterator();
      }
      return output(this.key, this.valueIterator.next());
    }

    abstract T output(K paramK, V paramV);
  }

  class Keys extends ImmutableMultiset<K>
  {
    Keys()
    {
    }

    public boolean contains(@Nullable Object paramObject)
    {
      return ImmutableMultimap.this.containsKey(paramObject);
    }

    public int count(@Nullable Object paramObject)
    {
      Collection localCollection = (Collection)ImmutableMultimap.this.map.get(paramObject);
      if (localCollection == null)
        return 0;
      return localCollection.size();
    }

    public Set<K> elementSet()
    {
      return ImmutableMultimap.this.keySet();
    }

    Multiset.Entry<K> getEntry(int paramInt)
    {
      Map.Entry localEntry = (Map.Entry)ImmutableMultimap.this.map.entrySet().asList().get(paramInt);
      return Multisets.immutableEntry(localEntry.getKey(), ((Collection)localEntry.getValue()).size());
    }

    boolean isPartialView()
    {
      return true;
    }

    public int size()
    {
      return ImmutableMultimap.this.size();
    }
  }

  private static final class Values<K, V> extends ImmutableCollection<V>
  {
    private static final long serialVersionUID;
    private final transient ImmutableMultimap<K, V> multimap;

    Values(ImmutableMultimap<K, V> paramImmutableMultimap)
    {
      this.multimap = paramImmutableMultimap;
    }

    public boolean contains(@Nullable Object paramObject)
    {
      return this.multimap.containsValue(paramObject);
    }

    @GwtIncompatible("not present in emulated superclass")
    int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
    {
      Iterator localIterator = this.multimap.map.values().iterator();
      while (localIterator.hasNext())
        paramInt = ((ImmutableCollection)localIterator.next()).copyIntoArray(paramArrayOfObject, paramInt);
      return paramInt;
    }

    boolean isPartialView()
    {
      return true;
    }

    public UnmodifiableIterator<V> iterator()
    {
      return this.multimap.valueIterator();
    }

    public int size()
    {
      return this.multimap.size();
    }
  }
}