package com.google.common.reflect;

import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.Map;

final class TypeToken$TypeCollector$4 extends Ordering<K>
{
  TypeToken$TypeCollector$4(Comparator paramComparator, Map paramMap)
  {
  }

  public int compare(K paramK1, K paramK2)
  {
    return this.val$valueComparator.compare(this.val$map.get(paramK1), this.val$map.get(paramK2));
  }
}