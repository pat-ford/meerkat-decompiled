package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Maps
{
  static final Joiner.MapJoiner STANDARD_JOINER = Collections2.STANDARD_JOINER.withKeyValueSeparator("=");

  @Beta
  public static <A, B> Converter<A, B> asConverter(BiMap<A, B> paramBiMap)
  {
    return new BiMapConverter(paramBiMap);
  }

  static <K, V1, V2> Function<Map.Entry<K, V1>, Map.Entry<K, V2>> asEntryToEntryFunction(EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
  {
    Preconditions.checkNotNull(paramEntryTransformer);
    return new Function()
    {
      public Map.Entry<K, V2> apply(Map.Entry<K, V1> paramAnonymousEntry)
      {
        return Maps.transformEntry(this.val$transformer, paramAnonymousEntry);
      }
    };
  }

  static <K, V1, V2> Function<Map.Entry<K, V1>, V2> asEntryToValueFunction(EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
  {
    Preconditions.checkNotNull(paramEntryTransformer);
    return new Function()
    {
      public V2 apply(Map.Entry<K, V1> paramAnonymousEntry)
      {
        return this.val$transformer.transformEntry(paramAnonymousEntry.getKey(), paramAnonymousEntry.getValue());
      }
    };
  }

  static <K, V1, V2> EntryTransformer<K, V1, V2> asEntryTransformer(Function<? super V1, V2> paramFunction)
  {
    Preconditions.checkNotNull(paramFunction);
    return new EntryTransformer()
    {
      public V2 transformEntry(K paramAnonymousK, V1 paramAnonymousV1)
      {
        return this.val$function.apply(paramAnonymousV1);
      }
    };
  }

  @Beta
  public static <K, V> Map<K, V> asMap(Set<K> paramSet, Function<? super K, V> paramFunction)
  {
    if ((paramSet instanceof SortedSet))
      return asMap((SortedSet)paramSet, paramFunction);
    return new AsMapView(paramSet, paramFunction);
  }

  @Beta
  @GwtIncompatible("NavigableMap")
  public static <K, V> NavigableMap<K, V> asMap(NavigableSet<K> paramNavigableSet, Function<? super K, V> paramFunction)
  {
    return new NavigableAsMapView(paramNavigableSet, paramFunction);
  }

  @Beta
  public static <K, V> SortedMap<K, V> asMap(SortedSet<K> paramSortedSet, Function<? super K, V> paramFunction)
  {
    return Platform.mapsAsMapSortedSet(paramSortedSet, paramFunction);
  }

  static <K, V> Iterator<Map.Entry<K, V>> asMapEntryIterator(Set<K> paramSet, final Function<? super K, V> paramFunction)
  {
    return new TransformedIterator(paramSet.iterator())
    {
      Map.Entry<K, V> transform(K paramAnonymousK)
      {
        return Maps.immutableEntry(paramAnonymousK, paramFunction.apply(paramAnonymousK));
      }
    };
  }

  static <K, V> SortedMap<K, V> asMapSortedIgnoreNavigable(SortedSet<K> paramSortedSet, Function<? super K, V> paramFunction)
  {
    return new SortedAsMapView(paramSortedSet, paramFunction);
  }

  static <K, V1, V2> Function<V1, V2> asValueToValueFunction(EntryTransformer<? super K, V1, V2> paramEntryTransformer, final K paramK)
  {
    Preconditions.checkNotNull(paramEntryTransformer);
    return new Function()
    {
      public V2 apply(@Nullable V1 paramAnonymousV1)
      {
        return this.val$transformer.transformEntry(paramK, paramAnonymousV1);
      }
    };
  }

  static int capacity(int paramInt)
  {
    if (paramInt < 3)
    {
      CollectPreconditions.checkNonnegative(paramInt, "expectedSize");
      return paramInt + 1;
    }
    if (paramInt < 1073741824)
      return paramInt + paramInt / 3;
    return 2147483647;
  }

  static <K, V> boolean containsEntryImpl(Collection<Map.Entry<K, V>> paramCollection, Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry))
      return false;
    return paramCollection.contains(unmodifiableEntry((Map.Entry)paramObject));
  }

  static boolean containsKeyImpl(Map<?, ?> paramMap, @Nullable Object paramObject)
  {
    return Iterators.contains(keyIterator(paramMap.entrySet().iterator()), paramObject);
  }

  static boolean containsValueImpl(Map<?, ?> paramMap, @Nullable Object paramObject)
  {
    return Iterators.contains(valueIterator(paramMap.entrySet().iterator()), paramObject);
  }

  public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> paramMap1, Map<? extends K, ? extends V> paramMap2)
  {
    if ((paramMap1 instanceof SortedMap))
      return difference((SortedMap)paramMap1, paramMap2);
    return difference(paramMap1, paramMap2, Equivalence.equals());
  }

  @Beta
  public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> paramMap1, Map<? extends K, ? extends V> paramMap2, Equivalence<? super V> paramEquivalence)
  {
    Preconditions.checkNotNull(paramEquivalence);
    HashMap localHashMap1 = newHashMap();
    HashMap localHashMap2 = new HashMap(paramMap2);
    HashMap localHashMap3 = newHashMap();
    HashMap localHashMap4 = newHashMap();
    doDifference(paramMap1, paramMap2, paramEquivalence, localHashMap1, localHashMap2, localHashMap3, localHashMap4);
    return new MapDifferenceImpl(localHashMap1, localHashMap2, localHashMap3, localHashMap4);
  }

  public static <K, V> SortedMapDifference<K, V> difference(SortedMap<K, ? extends V> paramSortedMap, Map<? extends K, ? extends V> paramMap)
  {
    Preconditions.checkNotNull(paramSortedMap);
    Preconditions.checkNotNull(paramMap);
    Comparator localComparator = orNaturalOrder(paramSortedMap.comparator());
    TreeMap localTreeMap1 = newTreeMap(localComparator);
    TreeMap localTreeMap2 = newTreeMap(localComparator);
    localTreeMap2.putAll(paramMap);
    TreeMap localTreeMap3 = newTreeMap(localComparator);
    TreeMap localTreeMap4 = newTreeMap(localComparator);
    doDifference(paramSortedMap, paramMap, Equivalence.equals(), localTreeMap1, localTreeMap2, localTreeMap3, localTreeMap4);
    return new SortedMapDifferenceImpl(localTreeMap1, localTreeMap2, localTreeMap3, localTreeMap4);
  }

  private static <K, V> void doDifference(Map<? extends K, ? extends V> paramMap1, Map<? extends K, ? extends V> paramMap2, Equivalence<? super V> paramEquivalence, Map<K, V> paramMap3, Map<K, V> paramMap4, Map<K, V> paramMap5, Map<K, MapDifference.ValueDifference<V>> paramMap)
  {
    Iterator localIterator = paramMap1.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject1 = localEntry.getKey();
      Object localObject2 = localEntry.getValue();
      if (paramMap2.containsKey(localObject1))
      {
        Object localObject3 = paramMap4.remove(localObject1);
        if (paramEquivalence.equivalent(localObject2, localObject3))
          paramMap5.put(localObject1, localObject2);
        else
          paramMap.put(localObject1, ValueDifferenceImpl.create(localObject2, localObject3));
      }
      else
      {
        paramMap3.put(localObject1, localObject2);
      }
    }
  }

  static boolean equalsImpl(Map<?, ?> paramMap, Object paramObject)
  {
    if (paramMap == paramObject)
      return true;
    if ((paramObject instanceof Map))
    {
      Map localMap = (Map)paramObject;
      return paramMap.entrySet().equals(localMap.entrySet());
    }
    return false;
  }

  public static <K, V> BiMap<K, V> filterEntries(BiMap<K, V> paramBiMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
  {
    Preconditions.checkNotNull(paramBiMap);
    Preconditions.checkNotNull(paramPredicate);
    if ((paramBiMap instanceof FilteredEntryBiMap))
      return filterFiltered((FilteredEntryBiMap)paramBiMap, paramPredicate);
    return new FilteredEntryBiMap(paramBiMap, paramPredicate);
  }

  public static <K, V> Map<K, V> filterEntries(Map<K, V> paramMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
  {
    if ((paramMap instanceof SortedMap))
      return filterEntries((SortedMap)paramMap, paramPredicate);
    if ((paramMap instanceof BiMap))
      return filterEntries((BiMap)paramMap, paramPredicate);
    Preconditions.checkNotNull(paramPredicate);
    if ((paramMap instanceof AbstractFilteredMap))
      return filterFiltered((AbstractFilteredMap)paramMap, paramPredicate);
    return new FilteredEntryMap((Map)Preconditions.checkNotNull(paramMap), paramPredicate);
  }

  @GwtIncompatible("NavigableMap")
  public static <K, V> NavigableMap<K, V> filterEntries(NavigableMap<K, V> paramNavigableMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
  {
    Preconditions.checkNotNull(paramPredicate);
    if ((paramNavigableMap instanceof FilteredEntryNavigableMap))
      return filterFiltered((FilteredEntryNavigableMap)paramNavigableMap, paramPredicate);
    return new FilteredEntryNavigableMap((NavigableMap)Preconditions.checkNotNull(paramNavigableMap), paramPredicate);
  }

  public static <K, V> SortedMap<K, V> filterEntries(SortedMap<K, V> paramSortedMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
  {
    return Platform.mapsFilterSortedMap(paramSortedMap, paramPredicate);
  }

  private static <K, V> BiMap<K, V> filterFiltered(FilteredEntryBiMap<K, V> paramFilteredEntryBiMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
  {
    Predicate localPredicate = Predicates.and(paramFilteredEntryBiMap.predicate, paramPredicate);
    return new FilteredEntryBiMap(paramFilteredEntryBiMap.unfiltered(), localPredicate);
  }

  private static <K, V> Map<K, V> filterFiltered(AbstractFilteredMap<K, V> paramAbstractFilteredMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
  {
    return new FilteredEntryMap(paramAbstractFilteredMap.unfiltered, Predicates.and(paramAbstractFilteredMap.predicate, paramPredicate));
  }

  @GwtIncompatible("NavigableMap")
  private static <K, V> NavigableMap<K, V> filterFiltered(FilteredEntryNavigableMap<K, V> paramFilteredEntryNavigableMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
  {
    Predicate localPredicate = Predicates.and(paramFilteredEntryNavigableMap.entryPredicate, paramPredicate);
    return new FilteredEntryNavigableMap(paramFilteredEntryNavigableMap.unfiltered, localPredicate);
  }

  private static <K, V> SortedMap<K, V> filterFiltered(FilteredEntrySortedMap<K, V> paramFilteredEntrySortedMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
  {
    Predicate localPredicate = Predicates.and(paramFilteredEntrySortedMap.predicate, paramPredicate);
    return new FilteredEntrySortedMap(paramFilteredEntrySortedMap.sortedMap(), localPredicate);
  }

  public static <K, V> BiMap<K, V> filterKeys(BiMap<K, V> paramBiMap, Predicate<? super K> paramPredicate)
  {
    Preconditions.checkNotNull(paramPredicate);
    return filterEntries(paramBiMap, keyPredicateOnEntries(paramPredicate));
  }

  public static <K, V> Map<K, V> filterKeys(Map<K, V> paramMap, Predicate<? super K> paramPredicate)
  {
    if ((paramMap instanceof SortedMap))
      return filterKeys((SortedMap)paramMap, paramPredicate);
    if ((paramMap instanceof BiMap))
      return filterKeys((BiMap)paramMap, paramPredicate);
    Preconditions.checkNotNull(paramPredicate);
    Predicate localPredicate = keyPredicateOnEntries(paramPredicate);
    if ((paramMap instanceof AbstractFilteredMap))
      return filterFiltered((AbstractFilteredMap)paramMap, localPredicate);
    return new FilteredKeyMap((Map)Preconditions.checkNotNull(paramMap), paramPredicate, localPredicate);
  }

  @GwtIncompatible("NavigableMap")
  public static <K, V> NavigableMap<K, V> filterKeys(NavigableMap<K, V> paramNavigableMap, Predicate<? super K> paramPredicate)
  {
    return filterEntries(paramNavigableMap, keyPredicateOnEntries(paramPredicate));
  }

  public static <K, V> SortedMap<K, V> filterKeys(SortedMap<K, V> paramSortedMap, Predicate<? super K> paramPredicate)
  {
    return filterEntries(paramSortedMap, keyPredicateOnEntries(paramPredicate));
  }

  static <K, V> SortedMap<K, V> filterSortedIgnoreNavigable(SortedMap<K, V> paramSortedMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
  {
    Preconditions.checkNotNull(paramPredicate);
    if ((paramSortedMap instanceof FilteredEntrySortedMap))
      return filterFiltered((FilteredEntrySortedMap)paramSortedMap, paramPredicate);
    return new FilteredEntrySortedMap((SortedMap)Preconditions.checkNotNull(paramSortedMap), paramPredicate);
  }

  public static <K, V> BiMap<K, V> filterValues(BiMap<K, V> paramBiMap, Predicate<? super V> paramPredicate)
  {
    return filterEntries(paramBiMap, valuePredicateOnEntries(paramPredicate));
  }

  public static <K, V> Map<K, V> filterValues(Map<K, V> paramMap, Predicate<? super V> paramPredicate)
  {
    if ((paramMap instanceof SortedMap))
      return filterValues((SortedMap)paramMap, paramPredicate);
    if ((paramMap instanceof BiMap))
      return filterValues((BiMap)paramMap, paramPredicate);
    return filterEntries(paramMap, valuePredicateOnEntries(paramPredicate));
  }

  @GwtIncompatible("NavigableMap")
  public static <K, V> NavigableMap<K, V> filterValues(NavigableMap<K, V> paramNavigableMap, Predicate<? super V> paramPredicate)
  {
    return filterEntries(paramNavigableMap, valuePredicateOnEntries(paramPredicate));
  }

  public static <K, V> SortedMap<K, V> filterValues(SortedMap<K, V> paramSortedMap, Predicate<? super V> paramPredicate)
  {
    return filterEntries(paramSortedMap, valuePredicateOnEntries(paramPredicate));
  }

  @GwtIncompatible("java.util.Properties")
  public static ImmutableMap<String, String> fromProperties(Properties paramProperties)
  {
    ImmutableMap.Builder localBuilder = ImmutableMap.builder();
    Enumeration localEnumeration = paramProperties.propertyNames();
    while (localEnumeration.hasMoreElements())
    {
      String str = (String)localEnumeration.nextElement();
      localBuilder.put(str, paramProperties.getProperty(str));
    }
    return localBuilder.build();
  }

  @GwtCompatible(serializable=true)
  public static <K, V> Map.Entry<K, V> immutableEntry(@Nullable K paramK, @Nullable V paramV)
  {
    return new ImmutableEntry(paramK, paramV);
  }

  @Beta
  @GwtCompatible(serializable=true)
  public static <K extends Enum<K>, V> ImmutableMap<K, V> immutableEnumMap(Map<K, ? extends V> paramMap)
  {
    if ((paramMap instanceof ImmutableEnumMap))
      return (ImmutableEnumMap)paramMap;
    if (paramMap.isEmpty())
      return ImmutableMap.of();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Preconditions.checkNotNull(localEntry.getKey());
      Preconditions.checkNotNull(localEntry.getValue());
    }
    return ImmutableEnumMap.asImmutable(new EnumMap(paramMap));
  }

  static <K> Function<Map.Entry<K, ?>, K> keyFunction()
  {
    return EntryFunction.KEY;
  }

  static <K, V> Iterator<K> keyIterator(Iterator<Map.Entry<K, V>> paramIterator)
  {
    return Iterators.transform(paramIterator, keyFunction());
  }

  @Nullable
  static <K> K keyOrNull(@Nullable Map.Entry<K, ?> paramEntry)
  {
    if (paramEntry == null)
      return null;
    return paramEntry.getKey();
  }

  static <K> Predicate<Map.Entry<K, ?>> keyPredicateOnEntries(Predicate<? super K> paramPredicate)
  {
    return Predicates.compose(paramPredicate, keyFunction());
  }

  public static <K, V> ConcurrentMap<K, V> newConcurrentMap()
  {
    return new MapMaker().makeMap();
  }

  public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Class<K> paramClass)
  {
    return new EnumMap((Class)Preconditions.checkNotNull(paramClass));
  }

  public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Map<K, ? extends V> paramMap)
  {
    return new EnumMap(paramMap);
  }

  public static <K, V> HashMap<K, V> newHashMap()
  {
    return new HashMap();
  }

  public static <K, V> HashMap<K, V> newHashMap(Map<? extends K, ? extends V> paramMap)
  {
    return new HashMap(paramMap);
  }

  public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int paramInt)
  {
    return new HashMap(capacity(paramInt));
  }

  public static <K, V> IdentityHashMap<K, V> newIdentityHashMap()
  {
    return new IdentityHashMap();
  }

  public static <K, V> LinkedHashMap<K, V> newLinkedHashMap()
  {
    return new LinkedHashMap();
  }

  public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(Map<? extends K, ? extends V> paramMap)
  {
    return new LinkedHashMap(paramMap);
  }

  public static <K extends Comparable, V> TreeMap<K, V> newTreeMap()
  {
    return new TreeMap();
  }

  public static <C, K extends C, V> TreeMap<K, V> newTreeMap(@Nullable Comparator<C> paramComparator)
  {
    return new TreeMap(paramComparator);
  }

  public static <K, V> TreeMap<K, V> newTreeMap(SortedMap<K, ? extends V> paramSortedMap)
  {
    return new TreeMap(paramSortedMap);
  }

  static <E> Comparator<? super E> orNaturalOrder(@Nullable Comparator<? super E> paramComparator)
  {
    if (paramComparator != null)
      return paramComparator;
    return Ordering.natural();
  }

  static <K, V> void putAllImpl(Map<K, V> paramMap, Map<? extends K, ? extends V> paramMap1)
  {
    Iterator localIterator = paramMap1.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramMap.put(localEntry.getKey(), localEntry.getValue());
    }
  }

  static <K, V> boolean removeEntryImpl(Collection<Map.Entry<K, V>> paramCollection, Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry))
      return false;
    return paramCollection.remove(unmodifiableEntry((Map.Entry)paramObject));
  }

  @GwtIncompatible("NavigableSet")
  private static <E> NavigableSet<E> removeOnlyNavigableSet(NavigableSet<E> paramNavigableSet)
  {
    return new ForwardingNavigableSet()
    {
      public boolean add(E paramAnonymousE)
      {
        throw new UnsupportedOperationException();
      }

      public boolean addAll(Collection<? extends E> paramAnonymousCollection)
      {
        throw new UnsupportedOperationException();
      }

      protected NavigableSet<E> delegate()
      {
        return this.val$set;
      }

      public NavigableSet<E> descendingSet()
      {
        return Maps.removeOnlyNavigableSet(super.descendingSet());
      }

      public NavigableSet<E> headSet(E paramAnonymousE, boolean paramAnonymousBoolean)
      {
        return Maps.removeOnlyNavigableSet(super.headSet(paramAnonymousE, paramAnonymousBoolean));
      }

      public SortedSet<E> headSet(E paramAnonymousE)
      {
        return Maps.removeOnlySortedSet(super.headSet(paramAnonymousE));
      }

      public NavigableSet<E> subSet(E paramAnonymousE1, boolean paramAnonymousBoolean1, E paramAnonymousE2, boolean paramAnonymousBoolean2)
      {
        return Maps.removeOnlyNavigableSet(super.subSet(paramAnonymousE1, paramAnonymousBoolean1, paramAnonymousE2, paramAnonymousBoolean2));
      }

      public SortedSet<E> subSet(E paramAnonymousE1, E paramAnonymousE2)
      {
        return Maps.removeOnlySortedSet(super.subSet(paramAnonymousE1, paramAnonymousE2));
      }

      public NavigableSet<E> tailSet(E paramAnonymousE, boolean paramAnonymousBoolean)
      {
        return Maps.removeOnlyNavigableSet(super.tailSet(paramAnonymousE, paramAnonymousBoolean));
      }

      public SortedSet<E> tailSet(E paramAnonymousE)
      {
        return Maps.removeOnlySortedSet(super.tailSet(paramAnonymousE));
      }
    };
  }

  private static <E> Set<E> removeOnlySet(Set<E> paramSet)
  {
    return new ForwardingSet()
    {
      public boolean add(E paramAnonymousE)
      {
        throw new UnsupportedOperationException();
      }

      public boolean addAll(Collection<? extends E> paramAnonymousCollection)
      {
        throw new UnsupportedOperationException();
      }

      protected Set<E> delegate()
      {
        return this.val$set;
      }
    };
  }

  private static <E> SortedSet<E> removeOnlySortedSet(SortedSet<E> paramSortedSet)
  {
    return new ForwardingSortedSet()
    {
      public boolean add(E paramAnonymousE)
      {
        throw new UnsupportedOperationException();
      }

      public boolean addAll(Collection<? extends E> paramAnonymousCollection)
      {
        throw new UnsupportedOperationException();
      }

      protected SortedSet<E> delegate()
      {
        return this.val$set;
      }

      public SortedSet<E> headSet(E paramAnonymousE)
      {
        return Maps.removeOnlySortedSet(super.headSet(paramAnonymousE));
      }

      public SortedSet<E> subSet(E paramAnonymousE1, E paramAnonymousE2)
      {
        return Maps.removeOnlySortedSet(super.subSet(paramAnonymousE1, paramAnonymousE2));
      }

      public SortedSet<E> tailSet(E paramAnonymousE)
      {
        return Maps.removeOnlySortedSet(super.tailSet(paramAnonymousE));
      }
    };
  }

  static boolean safeContainsKey(Map<?, ?> paramMap, Object paramObject)
  {
    Preconditions.checkNotNull(paramMap);
    try
    {
      boolean bool = paramMap.containsKey(paramObject);
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      return false;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    return false;
  }

  static <V> V safeGet(Map<?, V> paramMap, @Nullable Object paramObject)
  {
    Preconditions.checkNotNull(paramMap);
    try
    {
      Object localObject = paramMap.get(paramObject);
      return localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      return null;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    return null;
  }

  static <V> V safeRemove(Map<?, V> paramMap, Object paramObject)
  {
    Preconditions.checkNotNull(paramMap);
    try
    {
      Object localObject = paramMap.remove(paramObject);
      return localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      return null;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    return null;
  }

  public static <K, V> BiMap<K, V> synchronizedBiMap(BiMap<K, V> paramBiMap)
  {
    return Synchronized.biMap(paramBiMap, null);
  }

  @GwtIncompatible("NavigableMap")
  public static <K, V> NavigableMap<K, V> synchronizedNavigableMap(NavigableMap<K, V> paramNavigableMap)
  {
    return Synchronized.navigableMap(paramNavigableMap);
  }

  @Beta
  public static <K, V> ImmutableMap<K, V> toMap(Iterable<K> paramIterable, Function<? super K, V> paramFunction)
  {
    return toMap(paramIterable.iterator(), paramFunction);
  }

  @Beta
  public static <K, V> ImmutableMap<K, V> toMap(Iterator<K> paramIterator, Function<? super K, V> paramFunction)
  {
    Preconditions.checkNotNull(paramFunction);
    LinkedHashMap localLinkedHashMap = newLinkedHashMap();
    while (paramIterator.hasNext())
    {
      Object localObject = paramIterator.next();
      localLinkedHashMap.put(localObject, paramFunction.apply(localObject));
    }
    return ImmutableMap.copyOf(localLinkedHashMap);
  }

  static String toStringImpl(Map<?, ?> paramMap)
  {
    StringBuilder localStringBuilder = Collections2.newStringBuilderForCollection(paramMap.size()).append('{');
    STANDARD_JOINER.appendTo(localStringBuilder, paramMap);
    return '}';
  }

  public static <K, V1, V2> Map<K, V2> transformEntries(Map<K, V1> paramMap, EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
  {
    if ((paramMap instanceof SortedMap))
      return transformEntries((SortedMap)paramMap, paramEntryTransformer);
    return new TransformedEntriesMap(paramMap, paramEntryTransformer);
  }

  @GwtIncompatible("NavigableMap")
  public static <K, V1, V2> NavigableMap<K, V2> transformEntries(NavigableMap<K, V1> paramNavigableMap, EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
  {
    return new TransformedEntriesNavigableMap(paramNavigableMap, paramEntryTransformer);
  }

  public static <K, V1, V2> SortedMap<K, V2> transformEntries(SortedMap<K, V1> paramSortedMap, EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
  {
    return Platform.mapsTransformEntriesSortedMap(paramSortedMap, paramEntryTransformer);
  }

  static <K, V1, V2> SortedMap<K, V2> transformEntriesIgnoreNavigable(SortedMap<K, V1> paramSortedMap, EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
  {
    return new TransformedEntriesSortedMap(paramSortedMap, paramEntryTransformer);
  }

  static <V2, K, V1> Map.Entry<K, V2> transformEntry(final EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer, Map.Entry<K, V1> paramEntry)
  {
    Preconditions.checkNotNull(paramEntryTransformer);
    Preconditions.checkNotNull(paramEntry);
    return new AbstractMapEntry()
    {
      public K getKey()
      {
        return this.val$entry.getKey();
      }

      public V2 getValue()
      {
        return paramEntryTransformer.transformEntry(this.val$entry.getKey(), this.val$entry.getValue());
      }
    };
  }

  public static <K, V1, V2> Map<K, V2> transformValues(Map<K, V1> paramMap, Function<? super V1, V2> paramFunction)
  {
    return transformEntries(paramMap, asEntryTransformer(paramFunction));
  }

  @GwtIncompatible("NavigableMap")
  public static <K, V1, V2> NavigableMap<K, V2> transformValues(NavigableMap<K, V1> paramNavigableMap, Function<? super V1, V2> paramFunction)
  {
    return transformEntries(paramNavigableMap, asEntryTransformer(paramFunction));
  }

  public static <K, V1, V2> SortedMap<K, V2> transformValues(SortedMap<K, V1> paramSortedMap, Function<? super V1, V2> paramFunction)
  {
    return transformEntries(paramSortedMap, asEntryTransformer(paramFunction));
  }

  public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterable<V> paramIterable, Function<? super V, K> paramFunction)
  {
    return uniqueIndex(paramIterable.iterator(), paramFunction);
  }

  public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterator<V> paramIterator, Function<? super V, K> paramFunction)
  {
    Preconditions.checkNotNull(paramFunction);
    ImmutableMap.Builder localBuilder = ImmutableMap.builder();
    while (paramIterator.hasNext())
    {
      Object localObject = paramIterator.next();
      localBuilder.put(paramFunction.apply(localObject), localObject);
    }
    return localBuilder.build();
  }

  public static <K, V> BiMap<K, V> unmodifiableBiMap(BiMap<? extends K, ? extends V> paramBiMap)
  {
    return new UnmodifiableBiMap(paramBiMap, null);
  }

  static <K, V> Map.Entry<K, V> unmodifiableEntry(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    Preconditions.checkNotNull(paramEntry);
    return new AbstractMapEntry()
    {
      public K getKey()
      {
        return this.val$entry.getKey();
      }

      public V getValue()
      {
        return this.val$entry.getValue();
      }
    };
  }

  static <K, V> Set<Map.Entry<K, V>> unmodifiableEntrySet(Set<Map.Entry<K, V>> paramSet)
  {
    return new UnmodifiableEntrySet(Collections.unmodifiableSet(paramSet));
  }

  private static <K, V> Map<K, V> unmodifiableMap(Map<K, V> paramMap)
  {
    if ((paramMap instanceof SortedMap))
      return Collections.unmodifiableSortedMap((SortedMap)paramMap);
    return Collections.unmodifiableMap(paramMap);
  }

  @GwtIncompatible("NavigableMap")
  public static <K, V> NavigableMap<K, V> unmodifiableNavigableMap(NavigableMap<K, V> paramNavigableMap)
  {
    Preconditions.checkNotNull(paramNavigableMap);
    if ((paramNavigableMap instanceof UnmodifiableNavigableMap))
      return paramNavigableMap;
    return new UnmodifiableNavigableMap(paramNavigableMap);
  }

  @Nullable
  private static <K, V> Map.Entry<K, V> unmodifiableOrNull(@Nullable Map.Entry<K, V> paramEntry)
  {
    if (paramEntry == null)
      return null;
    return unmodifiableEntry(paramEntry);
  }

  static <V> Function<Map.Entry<?, V>, V> valueFunction()
  {
    return EntryFunction.VALUE;
  }

  static <K, V> UnmodifiableIterator<V> valueIterator(UnmodifiableIterator<Map.Entry<K, V>> paramUnmodifiableIterator)
  {
    return new UnmodifiableIterator()
    {
      public boolean hasNext()
      {
        return this.val$entryIterator.hasNext();
      }

      public V next()
      {
        return ((Map.Entry)this.val$entryIterator.next()).getValue();
      }
    };
  }

  static <K, V> Iterator<V> valueIterator(Iterator<Map.Entry<K, V>> paramIterator)
  {
    return Iterators.transform(paramIterator, valueFunction());
  }

  @Nullable
  static <V> V valueOrNull(@Nullable Map.Entry<?, V> paramEntry)
  {
    if (paramEntry == null)
      return null;
    return paramEntry.getValue();
  }

  static <V> Predicate<Map.Entry<?, V>> valuePredicateOnEntries(Predicate<? super V> paramPredicate)
  {
    return Predicates.compose(paramPredicate, valueFunction());
  }

  private static abstract class AbstractFilteredMap<K, V> extends Maps.ImprovedAbstractMap<K, V>
  {
    final Predicate<? super Map.Entry<K, V>> predicate;
    final Map<K, V> unfiltered;

    AbstractFilteredMap(Map<K, V> paramMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
    {
      this.unfiltered = paramMap;
      this.predicate = paramPredicate;
    }

    boolean apply(@Nullable Object paramObject, @Nullable V paramV)
    {
      return this.predicate.apply(Maps.immutableEntry(paramObject, paramV));
    }

    public boolean containsKey(Object paramObject)
    {
      return (this.unfiltered.containsKey(paramObject)) && (apply(paramObject, this.unfiltered.get(paramObject)));
    }

    Collection<V> createValues()
    {
      return new Maps.FilteredMapValues(this, this.unfiltered, this.predicate);
    }

    public V get(Object paramObject)
    {
      Object localObject = this.unfiltered.get(paramObject);
      if ((localObject != null) && (apply(paramObject, localObject)))
        return localObject;
      return null;
    }

    public boolean isEmpty()
    {
      return entrySet().isEmpty();
    }

    public V put(K paramK, V paramV)
    {
      Preconditions.checkArgument(apply(paramK, paramV));
      return this.unfiltered.put(paramK, paramV);
    }

    public void putAll(Map<? extends K, ? extends V> paramMap)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Preconditions.checkArgument(apply(localEntry.getKey(), localEntry.getValue()));
      }
      this.unfiltered.putAll(paramMap);
    }

    public V remove(Object paramObject)
    {
      if (containsKey(paramObject))
        return this.unfiltered.remove(paramObject);
      return null;
    }
  }

  private static class AsMapView<K, V> extends Maps.ImprovedAbstractMap<K, V>
  {
    final Function<? super K, V> function;
    private final Set<K> set;

    AsMapView(Set<K> paramSet, Function<? super K, V> paramFunction)
    {
      this.set = ((Set)Preconditions.checkNotNull(paramSet));
      this.function = ((Function)Preconditions.checkNotNull(paramFunction));
    }

    Set<K> backingSet()
    {
      return this.set;
    }

    public void clear()
    {
      backingSet().clear();
    }

    public boolean containsKey(@Nullable Object paramObject)
    {
      return backingSet().contains(paramObject);
    }

    protected Set<Map.Entry<K, V>> createEntrySet()
    {
      return new Maps.EntrySet()
      {
        public Iterator<Map.Entry<K, V>> iterator()
        {
          return Maps.asMapEntryIterator(Maps.AsMapView.this.backingSet(), Maps.AsMapView.this.function);
        }

        Map<K, V> map()
        {
          return Maps.AsMapView.this;
        }
      };
    }

    public Set<K> createKeySet()
    {
      return Maps.removeOnlySet(backingSet());
    }

    Collection<V> createValues()
    {
      return Collections2.transform(this.set, this.function);
    }

    public V get(@Nullable Object paramObject)
    {
      if (Collections2.safeContains(backingSet(), paramObject))
        return this.function.apply(paramObject);
      return null;
    }

    public V remove(@Nullable Object paramObject)
    {
      if (backingSet().remove(paramObject))
        return this.function.apply(paramObject);
      return null;
    }

    public int size()
    {
      return backingSet().size();
    }
  }

  private static final class BiMapConverter<A, B> extends Converter<A, B>
    implements Serializable
  {
    private static final long serialVersionUID;
    private final BiMap<A, B> bimap;

    BiMapConverter(BiMap<A, B> paramBiMap)
    {
      this.bimap = ((BiMap)Preconditions.checkNotNull(paramBiMap));
    }

    private static <X, Y> Y convert(BiMap<X, Y> paramBiMap, X paramX)
    {
      Object localObject = paramBiMap.get(paramX);
      if (localObject != null);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkArgument(bool, "No non-null mapping present for input: %s", new Object[] { paramX });
        return localObject;
      }
    }

    protected A doBackward(B paramB)
    {
      return convert(this.bimap.inverse(), paramB);
    }

    protected B doForward(A paramA)
    {
      return convert(this.bimap, paramA);
    }

    public boolean equals(@Nullable Object paramObject)
    {
      if ((paramObject instanceof BiMapConverter))
      {
        BiMapConverter localBiMapConverter = (BiMapConverter)paramObject;
        return this.bimap.equals(localBiMapConverter.bimap);
      }
      return false;
    }

    public int hashCode()
    {
      return this.bimap.hashCode();
    }

    public String toString()
    {
      String str = String.valueOf(String.valueOf(this.bimap));
      return 18 + str.length() + "Maps.asConverter(" + str + ")";
    }
  }

  @GwtIncompatible("NavigableMap")
  static abstract class DescendingMap<K, V> extends ForwardingMap<K, V>
    implements NavigableMap<K, V>
  {
    private transient Comparator<? super K> comparator;
    private transient Set<Map.Entry<K, V>> entrySet;
    private transient NavigableSet<K> navigableKeySet;

    private static <T> Ordering<T> reverse(Comparator<T> paramComparator)
    {
      return Ordering.from(paramComparator).reverse();
    }

    public Map.Entry<K, V> ceilingEntry(K paramK)
    {
      return forward().floorEntry(paramK);
    }

    public K ceilingKey(K paramK)
    {
      return forward().floorKey(paramK);
    }

    public Comparator<? super K> comparator()
    {
      Object localObject1 = this.comparator;
      if (localObject1 == null)
      {
        Object localObject2 = forward().comparator();
        if (localObject2 == null)
          localObject2 = Ordering.natural();
        localObject1 = reverse((Comparator)localObject2);
        this.comparator = ((Comparator)localObject1);
      }
      return localObject1;
    }

    Set<Map.Entry<K, V>> createEntrySet()
    {
      return new Maps.EntrySet()
      {
        public Iterator<Map.Entry<K, V>> iterator()
        {
          return Maps.DescendingMap.this.entryIterator();
        }

        Map<K, V> map()
        {
          return Maps.DescendingMap.this;
        }
      };
    }

    protected final Map<K, V> delegate()
    {
      return forward();
    }

    public NavigableSet<K> descendingKeySet()
    {
      return forward().navigableKeySet();
    }

    public NavigableMap<K, V> descendingMap()
    {
      return forward();
    }

    abstract Iterator<Map.Entry<K, V>> entryIterator();

    public Set<Map.Entry<K, V>> entrySet()
    {
      Set localSet = this.entrySet;
      if (localSet == null)
      {
        localSet = createEntrySet();
        this.entrySet = localSet;
      }
      return localSet;
    }

    public Map.Entry<K, V> firstEntry()
    {
      return forward().lastEntry();
    }

    public K firstKey()
    {
      return forward().lastKey();
    }

    public Map.Entry<K, V> floorEntry(K paramK)
    {
      return forward().ceilingEntry(paramK);
    }

    public K floorKey(K paramK)
    {
      return forward().ceilingKey(paramK);
    }

    abstract NavigableMap<K, V> forward();

    public NavigableMap<K, V> headMap(K paramK, boolean paramBoolean)
    {
      return forward().tailMap(paramK, paramBoolean).descendingMap();
    }

    public SortedMap<K, V> headMap(K paramK)
    {
      return headMap(paramK, false);
    }

    public Map.Entry<K, V> higherEntry(K paramK)
    {
      return forward().lowerEntry(paramK);
    }

    public K higherKey(K paramK)
    {
      return forward().lowerKey(paramK);
    }

    public Set<K> keySet()
    {
      return navigableKeySet();
    }

    public Map.Entry<K, V> lastEntry()
    {
      return forward().firstEntry();
    }

    public K lastKey()
    {
      return forward().firstKey();
    }

    public Map.Entry<K, V> lowerEntry(K paramK)
    {
      return forward().higherEntry(paramK);
    }

    public K lowerKey(K paramK)
    {
      return forward().higherKey(paramK);
    }

    public NavigableSet<K> navigableKeySet()
    {
      Object localObject = this.navigableKeySet;
      if (localObject == null)
      {
        localObject = new Maps.NavigableKeySet(this);
        this.navigableKeySet = ((NavigableSet)localObject);
      }
      return localObject;
    }

    public Map.Entry<K, V> pollFirstEntry()
    {
      return forward().pollLastEntry();
    }

    public Map.Entry<K, V> pollLastEntry()
    {
      return forward().pollFirstEntry();
    }

    public NavigableMap<K, V> subMap(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2)
    {
      return forward().subMap(paramK2, paramBoolean2, paramK1, paramBoolean1).descendingMap();
    }

    public SortedMap<K, V> subMap(K paramK1, K paramK2)
    {
      return subMap(paramK1, true, paramK2, false);
    }

    public NavigableMap<K, V> tailMap(K paramK, boolean paramBoolean)
    {
      return forward().headMap(paramK, paramBoolean).descendingMap();
    }

    public SortedMap<K, V> tailMap(K paramK)
    {
      return tailMap(paramK, true);
    }

    public String toString()
    {
      return standardToString();
    }

    public Collection<V> values()
    {
      return new Maps.Values(this);
    }
  }

  private static abstract enum EntryFunction
    implements Function<Map.Entry<?, ?>, Object>
  {
    static
    {
      EntryFunction[] arrayOfEntryFunction = new EntryFunction[2];
      arrayOfEntryFunction[0] = KEY;
      arrayOfEntryFunction[1] = VALUE;
    }
  }

  static abstract class EntrySet<K, V> extends Sets.ImprovedAbstractSet<Map.Entry<K, V>>
  {
    public void clear()
    {
      map().clear();
    }

    public boolean contains(Object paramObject)
    {
      boolean bool1 = paramObject instanceof Map.Entry;
      boolean bool2 = false;
      if (bool1)
      {
        Map.Entry localEntry = (Map.Entry)paramObject;
        Object localObject1 = localEntry.getKey();
        Object localObject2 = Maps.safeGet(map(), localObject1);
        boolean bool3 = Objects.equal(localObject2, localEntry.getValue());
        bool2 = false;
        if (bool3)
          if (localObject2 == null)
          {
            boolean bool4 = map().containsKey(localObject1);
            bool2 = false;
            if (!bool4);
          }
          else
          {
            bool2 = true;
          }
      }
      return bool2;
    }

    public boolean isEmpty()
    {
      return map().isEmpty();
    }

    abstract Map<K, V> map();

    public boolean remove(Object paramObject)
    {
      if (contains(paramObject))
      {
        Map.Entry localEntry = (Map.Entry)paramObject;
        return map().keySet().remove(localEntry.getKey());
      }
      return false;
    }

    public boolean removeAll(Collection<?> paramCollection)
    {
      try
      {
        boolean bool = super.removeAll((Collection)Preconditions.checkNotNull(paramCollection));
        return bool;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
      }
      return Sets.removeAllImpl(this, paramCollection.iterator());
    }

    public boolean retainAll(Collection<?> paramCollection)
    {
      try
      {
        boolean bool = super.retainAll((Collection)Preconditions.checkNotNull(paramCollection));
        return bool;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        HashSet localHashSet = Sets.newHashSetWithExpectedSize(paramCollection.size());
        Iterator localIterator = paramCollection.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          if (contains(localObject))
            localHashSet.add(((Map.Entry)localObject).getKey());
        }
        return map().keySet().retainAll(localHashSet);
      }
    }

    public int size()
    {
      return map().size();
    }
  }

  public static abstract interface EntryTransformer<K, V1, V2>
  {
    public abstract V2 transformEntry(@Nullable K paramK, @Nullable V1 paramV1);
  }

  static final class FilteredEntryBiMap<K, V> extends Maps.FilteredEntryMap<K, V>
    implements BiMap<K, V>
  {
    private final BiMap<V, K> inverse;

    FilteredEntryBiMap(BiMap<K, V> paramBiMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
    {
      super(paramPredicate);
      this.inverse = new FilteredEntryBiMap(paramBiMap.inverse(), inversePredicate(paramPredicate), this);
    }

    private FilteredEntryBiMap(BiMap<K, V> paramBiMap, Predicate<? super Map.Entry<K, V>> paramPredicate, BiMap<V, K> paramBiMap1)
    {
      super(paramPredicate);
      this.inverse = paramBiMap1;
    }

    private static <K, V> Predicate<Map.Entry<V, K>> inversePredicate(Predicate<? super Map.Entry<K, V>> paramPredicate)
    {
      return new Predicate()
      {
        public boolean apply(Map.Entry<V, K> paramAnonymousEntry)
        {
          return this.val$forwardPredicate.apply(Maps.immutableEntry(paramAnonymousEntry.getValue(), paramAnonymousEntry.getKey()));
        }
      };
    }

    public V forcePut(@Nullable K paramK, @Nullable V paramV)
    {
      Preconditions.checkArgument(apply(paramK, paramV));
      return unfiltered().forcePut(paramK, paramV);
    }

    public BiMap<V, K> inverse()
    {
      return this.inverse;
    }

    BiMap<K, V> unfiltered()
    {
      return (BiMap)this.unfiltered;
    }

    public Set<V> values()
    {
      return this.inverse.keySet();
    }
  }

  static class FilteredEntryMap<K, V> extends Maps.AbstractFilteredMap<K, V>
  {
    final Set<Map.Entry<K, V>> filteredEntrySet = Sets.filter(paramMap.entrySet(), this.predicate);

    FilteredEntryMap(Map<K, V> paramMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
    {
      super(paramPredicate);
    }

    protected Set<Map.Entry<K, V>> createEntrySet()
    {
      return new EntrySet(null);
    }

    Set<K> createKeySet()
    {
      return new KeySet();
    }

    private class EntrySet extends ForwardingSet<Map.Entry<K, V>>
    {
      private EntrySet()
      {
      }

      protected Set<Map.Entry<K, V>> delegate()
      {
        return Maps.FilteredEntryMap.this.filteredEntrySet;
      }

      public Iterator<Map.Entry<K, V>> iterator()
      {
        return new TransformedIterator(Maps.FilteredEntryMap.this.filteredEntrySet.iterator())
        {
          Map.Entry<K, V> transform(final Map.Entry<K, V> paramAnonymousEntry)
          {
            return new ForwardingMapEntry()
            {
              protected Map.Entry<K, V> delegate()
              {
                return paramAnonymousEntry;
              }

              public V setValue(V paramAnonymous2V)
              {
                Preconditions.checkArgument(Maps.FilteredEntryMap.this.apply(getKey(), paramAnonymous2V));
                return super.setValue(paramAnonymous2V);
              }
            };
          }
        };
      }
    }

    class KeySet extends Maps.KeySet<K, V>
    {
      KeySet()
      {
        super();
      }

      private boolean removeIf(Predicate<? super K> paramPredicate)
      {
        return Iterables.removeIf(Maps.FilteredEntryMap.this.unfiltered.entrySet(), Predicates.and(Maps.FilteredEntryMap.this.predicate, Maps.keyPredicateOnEntries(paramPredicate)));
      }

      public boolean remove(Object paramObject)
      {
        if (Maps.FilteredEntryMap.this.containsKey(paramObject))
        {
          Maps.FilteredEntryMap.this.unfiltered.remove(paramObject);
          return true;
        }
        return false;
      }

      public boolean removeAll(Collection<?> paramCollection)
      {
        return removeIf(Predicates.in(paramCollection));
      }

      public boolean retainAll(Collection<?> paramCollection)
      {
        return removeIf(Predicates.not(Predicates.in(paramCollection)));
      }

      public Object[] toArray()
      {
        return Lists.newArrayList(iterator()).toArray();
      }

      public <T> T[] toArray(T[] paramArrayOfT)
      {
        return Lists.newArrayList(iterator()).toArray(paramArrayOfT);
      }
    }
  }

  @GwtIncompatible("NavigableMap")
  private static class FilteredEntryNavigableMap<K, V> extends AbstractNavigableMap<K, V>
  {
    private final Predicate<? super Map.Entry<K, V>> entryPredicate;
    private final Map<K, V> filteredDelegate;
    private final NavigableMap<K, V> unfiltered;

    FilteredEntryNavigableMap(NavigableMap<K, V> paramNavigableMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
    {
      this.unfiltered = ((NavigableMap)Preconditions.checkNotNull(paramNavigableMap));
      this.entryPredicate = paramPredicate;
      this.filteredDelegate = new Maps.FilteredEntryMap(paramNavigableMap, paramPredicate);
    }

    public void clear()
    {
      this.filteredDelegate.clear();
    }

    public Comparator<? super K> comparator()
    {
      return this.unfiltered.comparator();
    }

    public boolean containsKey(@Nullable Object paramObject)
    {
      return this.filteredDelegate.containsKey(paramObject);
    }

    Iterator<Map.Entry<K, V>> descendingEntryIterator()
    {
      return Iterators.filter(this.unfiltered.descendingMap().entrySet().iterator(), this.entryPredicate);
    }

    public NavigableMap<K, V> descendingMap()
    {
      return Maps.filterEntries(this.unfiltered.descendingMap(), this.entryPredicate);
    }

    Iterator<Map.Entry<K, V>> entryIterator()
    {
      return Iterators.filter(this.unfiltered.entrySet().iterator(), this.entryPredicate);
    }

    public Set<Map.Entry<K, V>> entrySet()
    {
      return this.filteredDelegate.entrySet();
    }

    @Nullable
    public V get(@Nullable Object paramObject)
    {
      return this.filteredDelegate.get(paramObject);
    }

    public NavigableMap<K, V> headMap(K paramK, boolean paramBoolean)
    {
      return Maps.filterEntries(this.unfiltered.headMap(paramK, paramBoolean), this.entryPredicate);
    }

    public boolean isEmpty()
    {
      return !Iterables.any(this.unfiltered.entrySet(), this.entryPredicate);
    }

    public NavigableSet<K> navigableKeySet()
    {
      return new Maps.NavigableKeySet(this)
      {
        public boolean removeAll(Collection<?> paramAnonymousCollection)
        {
          return Iterators.removeIf(Maps.FilteredEntryNavigableMap.this.unfiltered.entrySet().iterator(), Predicates.and(Maps.FilteredEntryNavigableMap.this.entryPredicate, Maps.keyPredicateOnEntries(Predicates.in(paramAnonymousCollection))));
        }

        public boolean retainAll(Collection<?> paramAnonymousCollection)
        {
          return Iterators.removeIf(Maps.FilteredEntryNavigableMap.this.unfiltered.entrySet().iterator(), Predicates.and(Maps.FilteredEntryNavigableMap.this.entryPredicate, Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(paramAnonymousCollection)))));
        }
      };
    }

    public Map.Entry<K, V> pollFirstEntry()
    {
      return (Map.Entry)Iterables.removeFirstMatching(this.unfiltered.entrySet(), this.entryPredicate);
    }

    public Map.Entry<K, V> pollLastEntry()
    {
      return (Map.Entry)Iterables.removeFirstMatching(this.unfiltered.descendingMap().entrySet(), this.entryPredicate);
    }

    public V put(K paramK, V paramV)
    {
      return this.filteredDelegate.put(paramK, paramV);
    }

    public void putAll(Map<? extends K, ? extends V> paramMap)
    {
      this.filteredDelegate.putAll(paramMap);
    }

    public V remove(@Nullable Object paramObject)
    {
      return this.filteredDelegate.remove(paramObject);
    }

    public int size()
    {
      return this.filteredDelegate.size();
    }

    public NavigableMap<K, V> subMap(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2)
    {
      return Maps.filterEntries(this.unfiltered.subMap(paramK1, paramBoolean1, paramK2, paramBoolean2), this.entryPredicate);
    }

    public NavigableMap<K, V> tailMap(K paramK, boolean paramBoolean)
    {
      return Maps.filterEntries(this.unfiltered.tailMap(paramK, paramBoolean), this.entryPredicate);
    }

    public Collection<V> values()
    {
      return new Maps.FilteredMapValues(this, this.unfiltered, this.entryPredicate);
    }
  }

  private static class FilteredEntrySortedMap<K, V> extends Maps.FilteredEntryMap<K, V>
    implements SortedMap<K, V>
  {
    FilteredEntrySortedMap(SortedMap<K, V> paramSortedMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
    {
      super(paramPredicate);
    }

    public Comparator<? super K> comparator()
    {
      return sortedMap().comparator();
    }

    SortedSet<K> createKeySet()
    {
      return new SortedKeySet();
    }

    public K firstKey()
    {
      return keySet().iterator().next();
    }

    public SortedMap<K, V> headMap(K paramK)
    {
      return new FilteredEntrySortedMap(sortedMap().headMap(paramK), this.predicate);
    }

    public SortedSet<K> keySet()
    {
      return (SortedSet)super.keySet();
    }

    public K lastKey()
    {
      Object localObject;
      for (SortedMap localSortedMap = sortedMap(); ; localSortedMap = sortedMap().headMap(localObject))
      {
        localObject = localSortedMap.lastKey();
        if (apply(localObject, this.unfiltered.get(localObject)))
          return localObject;
      }
    }

    SortedMap<K, V> sortedMap()
    {
      return (SortedMap)this.unfiltered;
    }

    public SortedMap<K, V> subMap(K paramK1, K paramK2)
    {
      return new FilteredEntrySortedMap(sortedMap().subMap(paramK1, paramK2), this.predicate);
    }

    public SortedMap<K, V> tailMap(K paramK)
    {
      return new FilteredEntrySortedMap(sortedMap().tailMap(paramK), this.predicate);
    }

    class SortedKeySet extends Maps.FilteredEntryMap<K, V>.KeySet
      implements SortedSet<K>
    {
      SortedKeySet()
      {
        super();
      }

      public Comparator<? super K> comparator()
      {
        return Maps.FilteredEntrySortedMap.this.sortedMap().comparator();
      }

      public K first()
      {
        return Maps.FilteredEntrySortedMap.this.firstKey();
      }

      public SortedSet<K> headSet(K paramK)
      {
        return (SortedSet)Maps.FilteredEntrySortedMap.this.headMap(paramK).keySet();
      }

      public K last()
      {
        return Maps.FilteredEntrySortedMap.this.lastKey();
      }

      public SortedSet<K> subSet(K paramK1, K paramK2)
      {
        return (SortedSet)Maps.FilteredEntrySortedMap.this.subMap(paramK1, paramK2).keySet();
      }

      public SortedSet<K> tailSet(K paramK)
      {
        return (SortedSet)Maps.FilteredEntrySortedMap.this.tailMap(paramK).keySet();
      }
    }
  }

  private static class FilteredKeyMap<K, V> extends Maps.AbstractFilteredMap<K, V>
  {
    Predicate<? super K> keyPredicate;

    FilteredKeyMap(Map<K, V> paramMap, Predicate<? super K> paramPredicate, Predicate<? super Map.Entry<K, V>> paramPredicate1)
    {
      super(paramPredicate1);
      this.keyPredicate = paramPredicate;
    }

    public boolean containsKey(Object paramObject)
    {
      return (this.unfiltered.containsKey(paramObject)) && (this.keyPredicate.apply(paramObject));
    }

    protected Set<Map.Entry<K, V>> createEntrySet()
    {
      return Sets.filter(this.unfiltered.entrySet(), this.predicate);
    }

    Set<K> createKeySet()
    {
      return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
    }
  }

  private static final class FilteredMapValues<K, V> extends Maps.Values<K, V>
  {
    Predicate<? super Map.Entry<K, V>> predicate;
    Map<K, V> unfiltered;

    FilteredMapValues(Map<K, V> paramMap1, Map<K, V> paramMap2, Predicate<? super Map.Entry<K, V>> paramPredicate)
    {
      super();
      this.unfiltered = paramMap2;
      this.predicate = paramPredicate;
    }

    private boolean removeIf(Predicate<? super V> paramPredicate)
    {
      return Iterables.removeIf(this.unfiltered.entrySet(), Predicates.and(this.predicate, Maps.valuePredicateOnEntries(paramPredicate)));
    }

    public boolean remove(Object paramObject)
    {
      return Iterables.removeFirstMatching(this.unfiltered.entrySet(), Predicates.and(this.predicate, Maps.valuePredicateOnEntries(Predicates.equalTo(paramObject)))) != null;
    }

    public boolean removeAll(Collection<?> paramCollection)
    {
      return removeIf(Predicates.in(paramCollection));
    }

    public boolean retainAll(Collection<?> paramCollection)
    {
      return removeIf(Predicates.not(Predicates.in(paramCollection)));
    }

    public Object[] toArray()
    {
      return Lists.newArrayList(iterator()).toArray();
    }

    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return Lists.newArrayList(iterator()).toArray(paramArrayOfT);
    }
  }

  @GwtCompatible
  static abstract class ImprovedAbstractMap<K, V> extends AbstractMap<K, V>
  {
    private transient Set<Map.Entry<K, V>> entrySet;
    private transient Set<K> keySet;
    private transient Collection<V> values;

    abstract Set<Map.Entry<K, V>> createEntrySet();

    Set<K> createKeySet()
    {
      return new Maps.KeySet(this);
    }

    Collection<V> createValues()
    {
      return new Maps.Values(this);
    }

    public Set<Map.Entry<K, V>> entrySet()
    {
      Set localSet = this.entrySet;
      if (localSet == null)
      {
        localSet = createEntrySet();
        this.entrySet = localSet;
      }
      return localSet;
    }

    public Set<K> keySet()
    {
      Set localSet = this.keySet;
      if (localSet == null)
      {
        localSet = createKeySet();
        this.keySet = localSet;
      }
      return localSet;
    }

    public Collection<V> values()
    {
      Collection localCollection = this.values;
      if (localCollection == null)
      {
        localCollection = createValues();
        this.values = localCollection;
      }
      return localCollection;
    }
  }

  static class KeySet<K, V> extends Sets.ImprovedAbstractSet<K>
  {
    final Map<K, V> map;

    KeySet(Map<K, V> paramMap)
    {
      this.map = ((Map)Preconditions.checkNotNull(paramMap));
    }

    public void clear()
    {
      map().clear();
    }

    public boolean contains(Object paramObject)
    {
      return map().containsKey(paramObject);
    }

    public boolean isEmpty()
    {
      return map().isEmpty();
    }

    public Iterator<K> iterator()
    {
      return Maps.keyIterator(map().entrySet().iterator());
    }

    Map<K, V> map()
    {
      return this.map;
    }

    public boolean remove(Object paramObject)
    {
      if (contains(paramObject))
      {
        map().remove(paramObject);
        return true;
      }
      return false;
    }

    public int size()
    {
      return map().size();
    }
  }

  static class MapDifferenceImpl<K, V>
    implements MapDifference<K, V>
  {
    final Map<K, MapDifference.ValueDifference<V>> differences;
    final Map<K, V> onBoth;
    final Map<K, V> onlyOnLeft;
    final Map<K, V> onlyOnRight;

    MapDifferenceImpl(Map<K, V> paramMap1, Map<K, V> paramMap2, Map<K, V> paramMap3, Map<K, MapDifference.ValueDifference<V>> paramMap)
    {
      this.onlyOnLeft = Maps.unmodifiableMap(paramMap1);
      this.onlyOnRight = Maps.unmodifiableMap(paramMap2);
      this.onBoth = Maps.unmodifiableMap(paramMap3);
      this.differences = Maps.unmodifiableMap(paramMap);
    }

    public boolean areEqual()
    {
      return (this.onlyOnLeft.isEmpty()) && (this.onlyOnRight.isEmpty()) && (this.differences.isEmpty());
    }

    public Map<K, MapDifference.ValueDifference<V>> entriesDiffering()
    {
      return this.differences;
    }

    public Map<K, V> entriesInCommon()
    {
      return this.onBoth;
    }

    public Map<K, V> entriesOnlyOnLeft()
    {
      return this.onlyOnLeft;
    }

    public Map<K, V> entriesOnlyOnRight()
    {
      return this.onlyOnRight;
    }

    public boolean equals(Object paramObject)
    {
      if (paramObject == this);
      MapDifference localMapDifference;
      do
      {
        return true;
        if (!(paramObject instanceof MapDifference))
          break;
        localMapDifference = (MapDifference)paramObject;
      }
      while ((entriesOnlyOnLeft().equals(localMapDifference.entriesOnlyOnLeft())) && (entriesOnlyOnRight().equals(localMapDifference.entriesOnlyOnRight())) && (entriesInCommon().equals(localMapDifference.entriesInCommon())) && (entriesDiffering().equals(localMapDifference.entriesDiffering())));
      return false;
      return false;
    }

    public int hashCode()
    {
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = entriesOnlyOnLeft();
      arrayOfObject[1] = entriesOnlyOnRight();
      arrayOfObject[2] = entriesInCommon();
      arrayOfObject[3] = entriesDiffering();
      return Objects.hashCode(arrayOfObject);
    }

    public String toString()
    {
      if (areEqual())
        return "equal";
      StringBuilder localStringBuilder = new StringBuilder("not equal");
      if (!this.onlyOnLeft.isEmpty())
        localStringBuilder.append(": only on left=").append(this.onlyOnLeft);
      if (!this.onlyOnRight.isEmpty())
        localStringBuilder.append(": only on right=").append(this.onlyOnRight);
      if (!this.differences.isEmpty())
        localStringBuilder.append(": value differences=").append(this.differences);
      return localStringBuilder.toString();
    }
  }

  @GwtIncompatible("NavigableMap")
  private static final class NavigableAsMapView<K, V> extends AbstractNavigableMap<K, V>
  {
    private final Function<? super K, V> function;
    private final NavigableSet<K> set;

    NavigableAsMapView(NavigableSet<K> paramNavigableSet, Function<? super K, V> paramFunction)
    {
      this.set = ((NavigableSet)Preconditions.checkNotNull(paramNavigableSet));
      this.function = ((Function)Preconditions.checkNotNull(paramFunction));
    }

    public void clear()
    {
      this.set.clear();
    }

    public Comparator<? super K> comparator()
    {
      return this.set.comparator();
    }

    Iterator<Map.Entry<K, V>> descendingEntryIterator()
    {
      return descendingMap().entrySet().iterator();
    }

    public NavigableMap<K, V> descendingMap()
    {
      return Maps.asMap(this.set.descendingSet(), this.function);
    }

    Iterator<Map.Entry<K, V>> entryIterator()
    {
      return Maps.asMapEntryIterator(this.set, this.function);
    }

    @Nullable
    public V get(@Nullable Object paramObject)
    {
      if (Collections2.safeContains(this.set, paramObject))
        return this.function.apply(paramObject);
      return null;
    }

    public NavigableMap<K, V> headMap(K paramK, boolean paramBoolean)
    {
      return Maps.asMap(this.set.headSet(paramK, paramBoolean), this.function);
    }

    public NavigableSet<K> navigableKeySet()
    {
      return Maps.removeOnlyNavigableSet(this.set);
    }

    public int size()
    {
      return this.set.size();
    }

    public NavigableMap<K, V> subMap(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2)
    {
      return Maps.asMap(this.set.subSet(paramK1, paramBoolean1, paramK2, paramBoolean2), this.function);
    }

    public NavigableMap<K, V> tailMap(K paramK, boolean paramBoolean)
    {
      return Maps.asMap(this.set.tailSet(paramK, paramBoolean), this.function);
    }
  }

  @GwtIncompatible("NavigableMap")
  static class NavigableKeySet<K, V> extends Maps.SortedKeySet<K, V>
    implements NavigableSet<K>
  {
    NavigableKeySet(NavigableMap<K, V> paramNavigableMap)
    {
      super();
    }

    public K ceiling(K paramK)
    {
      return map().ceilingKey(paramK);
    }

    public Iterator<K> descendingIterator()
    {
      return descendingSet().iterator();
    }

    public NavigableSet<K> descendingSet()
    {
      return map().descendingKeySet();
    }

    public K floor(K paramK)
    {
      return map().floorKey(paramK);
    }

    public NavigableSet<K> headSet(K paramK, boolean paramBoolean)
    {
      return map().headMap(paramK, paramBoolean).navigableKeySet();
    }

    public SortedSet<K> headSet(K paramK)
    {
      return headSet(paramK, false);
    }

    public K higher(K paramK)
    {
      return map().higherKey(paramK);
    }

    public K lower(K paramK)
    {
      return map().lowerKey(paramK);
    }

    NavigableMap<K, V> map()
    {
      return (NavigableMap)this.map;
    }

    public K pollFirst()
    {
      return Maps.keyOrNull(map().pollFirstEntry());
    }

    public K pollLast()
    {
      return Maps.keyOrNull(map().pollLastEntry());
    }

    public NavigableSet<K> subSet(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2)
    {
      return map().subMap(paramK1, paramBoolean1, paramK2, paramBoolean2).navigableKeySet();
    }

    public SortedSet<K> subSet(K paramK1, K paramK2)
    {
      return subSet(paramK1, true, paramK2, false);
    }

    public NavigableSet<K> tailSet(K paramK, boolean paramBoolean)
    {
      return map().tailMap(paramK, paramBoolean).navigableKeySet();
    }

    public SortedSet<K> tailSet(K paramK)
    {
      return tailSet(paramK, true);
    }
  }

  private static class SortedAsMapView<K, V> extends Maps.AsMapView<K, V>
    implements SortedMap<K, V>
  {
    SortedAsMapView(SortedSet<K> paramSortedSet, Function<? super K, V> paramFunction)
    {
      super(paramFunction);
    }

    SortedSet<K> backingSet()
    {
      return (SortedSet)super.backingSet();
    }

    public Comparator<? super K> comparator()
    {
      return backingSet().comparator();
    }

    public K firstKey()
    {
      return backingSet().first();
    }

    public SortedMap<K, V> headMap(K paramK)
    {
      return Maps.asMap(backingSet().headSet(paramK), this.function);
    }

    public Set<K> keySet()
    {
      return Maps.removeOnlySortedSet(backingSet());
    }

    public K lastKey()
    {
      return backingSet().last();
    }

    public SortedMap<K, V> subMap(K paramK1, K paramK2)
    {
      return Maps.asMap(backingSet().subSet(paramK1, paramK2), this.function);
    }

    public SortedMap<K, V> tailMap(K paramK)
    {
      return Maps.asMap(backingSet().tailSet(paramK), this.function);
    }
  }

  static class SortedKeySet<K, V> extends Maps.KeySet<K, V>
    implements SortedSet<K>
  {
    SortedKeySet(SortedMap<K, V> paramSortedMap)
    {
      super();
    }

    public Comparator<? super K> comparator()
    {
      return map().comparator();
    }

    public K first()
    {
      return map().firstKey();
    }

    public SortedSet<K> headSet(K paramK)
    {
      return new SortedKeySet(map().headMap(paramK));
    }

    public K last()
    {
      return map().lastKey();
    }

    SortedMap<K, V> map()
    {
      return (SortedMap)super.map();
    }

    public SortedSet<K> subSet(K paramK1, K paramK2)
    {
      return new SortedKeySet(map().subMap(paramK1, paramK2));
    }

    public SortedSet<K> tailSet(K paramK)
    {
      return new SortedKeySet(map().tailMap(paramK));
    }
  }

  static class SortedMapDifferenceImpl<K, V> extends Maps.MapDifferenceImpl<K, V>
    implements SortedMapDifference<K, V>
  {
    SortedMapDifferenceImpl(SortedMap<K, V> paramSortedMap1, SortedMap<K, V> paramSortedMap2, SortedMap<K, V> paramSortedMap3, SortedMap<K, MapDifference.ValueDifference<V>> paramSortedMap)
    {
      super(paramSortedMap2, paramSortedMap3, paramSortedMap);
    }

    public SortedMap<K, MapDifference.ValueDifference<V>> entriesDiffering()
    {
      return (SortedMap)super.entriesDiffering();
    }

    public SortedMap<K, V> entriesInCommon()
    {
      return (SortedMap)super.entriesInCommon();
    }

    public SortedMap<K, V> entriesOnlyOnLeft()
    {
      return (SortedMap)super.entriesOnlyOnLeft();
    }

    public SortedMap<K, V> entriesOnlyOnRight()
    {
      return (SortedMap)super.entriesOnlyOnRight();
    }
  }

  static class TransformedEntriesMap<K, V1, V2> extends Maps.ImprovedAbstractMap<K, V2>
  {
    final Map<K, V1> fromMap;
    final Maps.EntryTransformer<? super K, ? super V1, V2> transformer;

    TransformedEntriesMap(Map<K, V1> paramMap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
    {
      this.fromMap = ((Map)Preconditions.checkNotNull(paramMap));
      this.transformer = ((Maps.EntryTransformer)Preconditions.checkNotNull(paramEntryTransformer));
    }

    public void clear()
    {
      this.fromMap.clear();
    }

    public boolean containsKey(Object paramObject)
    {
      return this.fromMap.containsKey(paramObject);
    }

    protected Set<Map.Entry<K, V2>> createEntrySet()
    {
      return new Maps.EntrySet()
      {
        public Iterator<Map.Entry<K, V2>> iterator()
        {
          return Iterators.transform(Maps.TransformedEntriesMap.this.fromMap.entrySet().iterator(), Maps.asEntryToEntryFunction(Maps.TransformedEntriesMap.this.transformer));
        }

        Map<K, V2> map()
        {
          return Maps.TransformedEntriesMap.this;
        }
      };
    }

    public V2 get(Object paramObject)
    {
      Object localObject = this.fromMap.get(paramObject);
      if ((localObject != null) || (this.fromMap.containsKey(paramObject)))
        return this.transformer.transformEntry(paramObject, localObject);
      return null;
    }

    public Set<K> keySet()
    {
      return this.fromMap.keySet();
    }

    public V2 remove(Object paramObject)
    {
      if (this.fromMap.containsKey(paramObject))
        return this.transformer.transformEntry(paramObject, this.fromMap.remove(paramObject));
      return null;
    }

    public int size()
    {
      return this.fromMap.size();
    }
  }

  @GwtIncompatible("NavigableMap")
  private static class TransformedEntriesNavigableMap<K, V1, V2> extends Maps.TransformedEntriesSortedMap<K, V1, V2>
    implements NavigableMap<K, V2>
  {
    TransformedEntriesNavigableMap(NavigableMap<K, V1> paramNavigableMap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
    {
      super(paramEntryTransformer);
    }

    @Nullable
    private Map.Entry<K, V2> transformEntry(@Nullable Map.Entry<K, V1> paramEntry)
    {
      if (paramEntry == null)
        return null;
      return Maps.transformEntry(this.transformer, paramEntry);
    }

    public Map.Entry<K, V2> ceilingEntry(K paramK)
    {
      return transformEntry(fromMap().ceilingEntry(paramK));
    }

    public K ceilingKey(K paramK)
    {
      return fromMap().ceilingKey(paramK);
    }

    public NavigableSet<K> descendingKeySet()
    {
      return fromMap().descendingKeySet();
    }

    public NavigableMap<K, V2> descendingMap()
    {
      return Maps.transformEntries(fromMap().descendingMap(), this.transformer);
    }

    public Map.Entry<K, V2> firstEntry()
    {
      return transformEntry(fromMap().firstEntry());
    }

    public Map.Entry<K, V2> floorEntry(K paramK)
    {
      return transformEntry(fromMap().floorEntry(paramK));
    }

    public K floorKey(K paramK)
    {
      return fromMap().floorKey(paramK);
    }

    protected NavigableMap<K, V1> fromMap()
    {
      return (NavigableMap)super.fromMap();
    }

    public NavigableMap<K, V2> headMap(K paramK)
    {
      return headMap(paramK, false);
    }

    public NavigableMap<K, V2> headMap(K paramK, boolean paramBoolean)
    {
      return Maps.transformEntries(fromMap().headMap(paramK, paramBoolean), this.transformer);
    }

    public Map.Entry<K, V2> higherEntry(K paramK)
    {
      return transformEntry(fromMap().higherEntry(paramK));
    }

    public K higherKey(K paramK)
    {
      return fromMap().higherKey(paramK);
    }

    public Map.Entry<K, V2> lastEntry()
    {
      return transformEntry(fromMap().lastEntry());
    }

    public Map.Entry<K, V2> lowerEntry(K paramK)
    {
      return transformEntry(fromMap().lowerEntry(paramK));
    }

    public K lowerKey(K paramK)
    {
      return fromMap().lowerKey(paramK);
    }

    public NavigableSet<K> navigableKeySet()
    {
      return fromMap().navigableKeySet();
    }

    public Map.Entry<K, V2> pollFirstEntry()
    {
      return transformEntry(fromMap().pollFirstEntry());
    }

    public Map.Entry<K, V2> pollLastEntry()
    {
      return transformEntry(fromMap().pollLastEntry());
    }

    public NavigableMap<K, V2> subMap(K paramK1, K paramK2)
    {
      return subMap(paramK1, true, paramK2, false);
    }

    public NavigableMap<K, V2> subMap(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2)
    {
      return Maps.transformEntries(fromMap().subMap(paramK1, paramBoolean1, paramK2, paramBoolean2), this.transformer);
    }

    public NavigableMap<K, V2> tailMap(K paramK)
    {
      return tailMap(paramK, true);
    }

    public NavigableMap<K, V2> tailMap(K paramK, boolean paramBoolean)
    {
      return Maps.transformEntries(fromMap().tailMap(paramK, paramBoolean), this.transformer);
    }
  }

  static class TransformedEntriesSortedMap<K, V1, V2> extends Maps.TransformedEntriesMap<K, V1, V2>
    implements SortedMap<K, V2>
  {
    TransformedEntriesSortedMap(SortedMap<K, V1> paramSortedMap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
    {
      super(paramEntryTransformer);
    }

    public Comparator<? super K> comparator()
    {
      return fromMap().comparator();
    }

    public K firstKey()
    {
      return fromMap().firstKey();
    }

    protected SortedMap<K, V1> fromMap()
    {
      return (SortedMap)this.fromMap;
    }

    public SortedMap<K, V2> headMap(K paramK)
    {
      return Maps.transformEntries(fromMap().headMap(paramK), this.transformer);
    }

    public K lastKey()
    {
      return fromMap().lastKey();
    }

    public SortedMap<K, V2> subMap(K paramK1, K paramK2)
    {
      return Maps.transformEntries(fromMap().subMap(paramK1, paramK2), this.transformer);
    }

    public SortedMap<K, V2> tailMap(K paramK)
    {
      return Maps.transformEntries(fromMap().tailMap(paramK), this.transformer);
    }
  }

  private static class UnmodifiableBiMap<K, V> extends ForwardingMap<K, V>
    implements BiMap<K, V>, Serializable
  {
    private static final long serialVersionUID;
    final BiMap<? extends K, ? extends V> delegate;
    BiMap<V, K> inverse;
    final Map<K, V> unmodifiableMap;
    transient Set<V> values;

    UnmodifiableBiMap(BiMap<? extends K, ? extends V> paramBiMap, @Nullable BiMap<V, K> paramBiMap1)
    {
      this.unmodifiableMap = Collections.unmodifiableMap(paramBiMap);
      this.delegate = paramBiMap;
      this.inverse = paramBiMap1;
    }

    protected Map<K, V> delegate()
    {
      return this.unmodifiableMap;
    }

    public V forcePut(K paramK, V paramV)
    {
      throw new UnsupportedOperationException();
    }

    public BiMap<V, K> inverse()
    {
      Object localObject = this.inverse;
      if (localObject == null)
      {
        localObject = new UnmodifiableBiMap(this.delegate.inverse(), this);
        this.inverse = ((BiMap)localObject);
      }
      return localObject;
    }

    public Set<V> values()
    {
      Set localSet = this.values;
      if (localSet == null)
      {
        localSet = Collections.unmodifiableSet(this.delegate.values());
        this.values = localSet;
      }
      return localSet;
    }
  }

  static class UnmodifiableEntries<K, V> extends ForwardingCollection<Map.Entry<K, V>>
  {
    private final Collection<Map.Entry<K, V>> entries;

    UnmodifiableEntries(Collection<Map.Entry<K, V>> paramCollection)
    {
      this.entries = paramCollection;
    }

    protected Collection<Map.Entry<K, V>> delegate()
    {
      return this.entries;
    }

    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new UnmodifiableIterator()
      {
        public boolean hasNext()
        {
          return this.val$delegate.hasNext();
        }

        public Map.Entry<K, V> next()
        {
          return Maps.unmodifiableEntry((Map.Entry)this.val$delegate.next());
        }
      };
    }

    public Object[] toArray()
    {
      return standardToArray();
    }

    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return standardToArray(paramArrayOfT);
    }
  }

  static class UnmodifiableEntrySet<K, V> extends Maps.UnmodifiableEntries<K, V>
    implements Set<Map.Entry<K, V>>
  {
    UnmodifiableEntrySet(Set<Map.Entry<K, V>> paramSet)
    {
      super();
    }

    public boolean equals(@Nullable Object paramObject)
    {
      return Sets.equalsImpl(this, paramObject);
    }

    public int hashCode()
    {
      return Sets.hashCodeImpl(this);
    }
  }

  @GwtIncompatible("NavigableMap")
  static class UnmodifiableNavigableMap<K, V> extends ForwardingSortedMap<K, V>
    implements NavigableMap<K, V>, Serializable
  {
    private final NavigableMap<K, V> delegate;
    private transient UnmodifiableNavigableMap<K, V> descendingMap;

    UnmodifiableNavigableMap(NavigableMap<K, V> paramNavigableMap)
    {
      this.delegate = paramNavigableMap;
    }

    UnmodifiableNavigableMap(NavigableMap<K, V> paramNavigableMap, UnmodifiableNavigableMap<K, V> paramUnmodifiableNavigableMap)
    {
      this.delegate = paramNavigableMap;
      this.descendingMap = paramUnmodifiableNavigableMap;
    }

    public Map.Entry<K, V> ceilingEntry(K paramK)
    {
      return Maps.unmodifiableOrNull(this.delegate.ceilingEntry(paramK));
    }

    public K ceilingKey(K paramK)
    {
      return this.delegate.ceilingKey(paramK);
    }

    protected SortedMap<K, V> delegate()
    {
      return Collections.unmodifiableSortedMap(this.delegate);
    }

    public NavigableSet<K> descendingKeySet()
    {
      return Sets.unmodifiableNavigableSet(this.delegate.descendingKeySet());
    }

    public NavigableMap<K, V> descendingMap()
    {
      UnmodifiableNavigableMap localUnmodifiableNavigableMap = this.descendingMap;
      if (localUnmodifiableNavigableMap == null)
      {
        localUnmodifiableNavigableMap = new UnmodifiableNavigableMap(this.delegate.descendingMap(), this);
        this.descendingMap = localUnmodifiableNavigableMap;
      }
      return localUnmodifiableNavigableMap;
    }

    public Map.Entry<K, V> firstEntry()
    {
      return Maps.unmodifiableOrNull(this.delegate.firstEntry());
    }

    public Map.Entry<K, V> floorEntry(K paramK)
    {
      return Maps.unmodifiableOrNull(this.delegate.floorEntry(paramK));
    }

    public K floorKey(K paramK)
    {
      return this.delegate.floorKey(paramK);
    }

    public NavigableMap<K, V> headMap(K paramK, boolean paramBoolean)
    {
      return Maps.unmodifiableNavigableMap(this.delegate.headMap(paramK, paramBoolean));
    }

    public SortedMap<K, V> headMap(K paramK)
    {
      return headMap(paramK, false);
    }

    public Map.Entry<K, V> higherEntry(K paramK)
    {
      return Maps.unmodifiableOrNull(this.delegate.higherEntry(paramK));
    }

    public K higherKey(K paramK)
    {
      return this.delegate.higherKey(paramK);
    }

    public Set<K> keySet()
    {
      return navigableKeySet();
    }

    public Map.Entry<K, V> lastEntry()
    {
      return Maps.unmodifiableOrNull(this.delegate.lastEntry());
    }

    public Map.Entry<K, V> lowerEntry(K paramK)
    {
      return Maps.unmodifiableOrNull(this.delegate.lowerEntry(paramK));
    }

    public K lowerKey(K paramK)
    {
      return this.delegate.lowerKey(paramK);
    }

    public NavigableSet<K> navigableKeySet()
    {
      return Sets.unmodifiableNavigableSet(this.delegate.navigableKeySet());
    }

    public final Map.Entry<K, V> pollFirstEntry()
    {
      throw new UnsupportedOperationException();
    }

    public final Map.Entry<K, V> pollLastEntry()
    {
      throw new UnsupportedOperationException();
    }

    public NavigableMap<K, V> subMap(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2)
    {
      return Maps.unmodifiableNavigableMap(this.delegate.subMap(paramK1, paramBoolean1, paramK2, paramBoolean2));
    }

    public SortedMap<K, V> subMap(K paramK1, K paramK2)
    {
      return subMap(paramK1, true, paramK2, false);
    }

    public NavigableMap<K, V> tailMap(K paramK, boolean paramBoolean)
    {
      return Maps.unmodifiableNavigableMap(this.delegate.tailMap(paramK, paramBoolean));
    }

    public SortedMap<K, V> tailMap(K paramK)
    {
      return tailMap(paramK, true);
    }
  }

  static class ValueDifferenceImpl<V>
    implements MapDifference.ValueDifference<V>
  {
    private final V left;
    private final V right;

    private ValueDifferenceImpl(@Nullable V paramV1, @Nullable V paramV2)
    {
      this.left = paramV1;
      this.right = paramV2;
    }

    static <V> MapDifference.ValueDifference<V> create(@Nullable V paramV1, @Nullable V paramV2)
    {
      return new ValueDifferenceImpl(paramV1, paramV2);
    }

    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool1 = paramObject instanceof MapDifference.ValueDifference;
      boolean bool2 = false;
      if (bool1)
      {
        MapDifference.ValueDifference localValueDifference = (MapDifference.ValueDifference)paramObject;
        boolean bool3 = Objects.equal(this.left, localValueDifference.leftValue());
        bool2 = false;
        if (bool3)
        {
          boolean bool4 = Objects.equal(this.right, localValueDifference.rightValue());
          bool2 = false;
          if (bool4)
            bool2 = true;
        }
      }
      return bool2;
    }

    public int hashCode()
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.left;
      arrayOfObject[1] = this.right;
      return Objects.hashCode(arrayOfObject);
    }

    public V leftValue()
    {
      return this.left;
    }

    public V rightValue()
    {
      return this.right;
    }

    public String toString()
    {
      String str1 = String.valueOf(String.valueOf(this.left));
      String str2 = String.valueOf(String.valueOf(this.right));
      return 4 + str1.length() + str2.length() + "(" + str1 + ", " + str2 + ")";
    }
  }

  static class Values<K, V> extends AbstractCollection<V>
  {
    final Map<K, V> map;

    Values(Map<K, V> paramMap)
    {
      this.map = ((Map)Preconditions.checkNotNull(paramMap));
    }

    public void clear()
    {
      map().clear();
    }

    public boolean contains(@Nullable Object paramObject)
    {
      return map().containsValue(paramObject);
    }

    public boolean isEmpty()
    {
      return map().isEmpty();
    }

    public Iterator<V> iterator()
    {
      return Maps.valueIterator(map().entrySet().iterator());
    }

    final Map<K, V> map()
    {
      return this.map;
    }

    public boolean remove(Object paramObject)
    {
      try
      {
        boolean bool = super.remove(paramObject);
        return bool;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        Iterator localIterator = map().entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (Objects.equal(paramObject, localEntry.getValue()))
          {
            map().remove(localEntry.getKey());
            return true;
          }
        }
      }
      return false;
    }

    public boolean removeAll(Collection<?> paramCollection)
    {
      try
      {
        boolean bool = super.removeAll((Collection)Preconditions.checkNotNull(paramCollection));
        return bool;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        HashSet localHashSet = Sets.newHashSet();
        Iterator localIterator = map().entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (paramCollection.contains(localEntry.getValue()))
            localHashSet.add(localEntry.getKey());
        }
        return map().keySet().removeAll(localHashSet);
      }
    }

    public boolean retainAll(Collection<?> paramCollection)
    {
      try
      {
        boolean bool = super.retainAll((Collection)Preconditions.checkNotNull(paramCollection));
        return bool;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        HashSet localHashSet = Sets.newHashSet();
        Iterator localIterator = map().entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (paramCollection.contains(localEntry.getValue()))
            localHashSet.add(localEntry.getKey());
        }
        return map().keySet().retainAll(localHashSet);
      }
    }

    public int size()
    {
      return map().size();
    }
  }
}