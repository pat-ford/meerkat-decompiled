package com.google.common.hash;

import java.io.Serializable;

class BloomFilter$SerialForm<T>
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  final long[] data;
  final Funnel<? super T> funnel;
  final int numHashFunctions;
  final BloomFilter.Strategy strategy;

  BloomFilter$SerialForm(BloomFilter<T> paramBloomFilter)
  {
    this.data = BloomFilter.access$000(paramBloomFilter).data;
    this.numHashFunctions = BloomFilter.access$100(paramBloomFilter);
    this.funnel = BloomFilter.access$200(paramBloomFilter);
    this.strategy = BloomFilter.access$300(paramBloomFilter);
  }

  Object readResolve()
  {
    return new BloomFilter(new BloomFilterStrategies.BitArray(this.data), this.numHashFunctions, this.funnel, this.strategy, null);
  }
}