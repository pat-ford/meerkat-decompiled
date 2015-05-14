package io.fabric.sdk.android.services.persistence;

public abstract interface SerializationStrategy<T>
{
  public abstract T deserialize(String paramString);

  public abstract String serialize(T paramT);
}