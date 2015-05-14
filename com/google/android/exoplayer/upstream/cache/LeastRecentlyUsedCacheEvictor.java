package com.google.android.exoplayer.upstream.cache;

import java.util.Comparator;
import java.util.TreeSet;

public class LeastRecentlyUsedCacheEvictor
  implements CacheEvictor, Comparator<CacheSpan>
{
  private long currentSize;
  private final TreeSet<CacheSpan> leastRecentlyUsed;
  private final long maxBytes;

  public LeastRecentlyUsedCacheEvictor(long paramLong)
  {
    this.maxBytes = paramLong;
    this.leastRecentlyUsed = new TreeSet(this);
  }

  private void evictCache(Cache paramCache, long paramLong)
  {
    while (paramLong + this.currentSize > this.maxBytes)
      paramCache.removeSpan((CacheSpan)this.leastRecentlyUsed.first());
  }

  public int compare(CacheSpan paramCacheSpan1, CacheSpan paramCacheSpan2)
  {
    if (paramCacheSpan1.lastAccessTimestamp - paramCacheSpan2.lastAccessTimestamp == 0L)
      return paramCacheSpan1.compareTo(paramCacheSpan2);
    if (paramCacheSpan1.lastAccessTimestamp < paramCacheSpan2.lastAccessTimestamp)
      return -1;
    return 1;
  }

  public void onSpanAdded(Cache paramCache, CacheSpan paramCacheSpan)
  {
    this.leastRecentlyUsed.add(paramCacheSpan);
    this.currentSize += paramCacheSpan.length;
    evictCache(paramCache, 0L);
  }

  public void onSpanRemoved(Cache paramCache, CacheSpan paramCacheSpan)
  {
    this.leastRecentlyUsed.remove(paramCacheSpan);
    this.currentSize -= paramCacheSpan.length;
  }

  public void onSpanTouched(Cache paramCache, CacheSpan paramCacheSpan1, CacheSpan paramCacheSpan2)
  {
    onSpanRemoved(paramCache, paramCacheSpan1);
    onSpanAdded(paramCache, paramCacheSpan2);
  }

  public void onStartFile(Cache paramCache, String paramString, long paramLong1, long paramLong2)
  {
    evictCache(paramCache, paramLong2);
  }
}