package io.fabric.sdk.android.services.settings;

public enum SettingsCacheBehavior
{
  static
  {
    SKIP_CACHE_LOOKUP = new SettingsCacheBehavior("SKIP_CACHE_LOOKUP", 1);
    IGNORE_CACHE_EXPIRATION = new SettingsCacheBehavior("IGNORE_CACHE_EXPIRATION", 2);
    SettingsCacheBehavior[] arrayOfSettingsCacheBehavior = new SettingsCacheBehavior[3];
    arrayOfSettingsCacheBehavior[0] = USE_CACHE;
    arrayOfSettingsCacheBehavior[1] = SKIP_CACHE_LOOKUP;
    arrayOfSettingsCacheBehavior[2] = IGNORE_CACHE_EXPIRATION;
  }
}