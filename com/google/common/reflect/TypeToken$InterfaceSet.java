package com.google.common.reflect;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

final class TypeToken$InterfaceSet extends TypeToken<T>.TypeSet
{
  private static final long serialVersionUID;
  private final transient TypeToken<T>.TypeSet allTypes;
  private transient ImmutableSet<TypeToken<? super T>> interfaces;

  TypeToken$InterfaceSet(TypeToken<T>.TypeSet paramTypeToken)
  {
    super(paramTypeToken);
    Object localObject;
    this.allTypes = localObject;
  }

  private Object readResolve()
  {
    return this.this$0.getTypes().interfaces();
  }

  public TypeToken<T>.TypeSet classes()
  {
    throw new UnsupportedOperationException("interfaces().classes() not supported.");
  }

  protected Set<TypeToken<? super T>> delegate()
  {
    ImmutableSet localImmutableSet = this.interfaces;
    if (localImmutableSet == null)
    {
      localImmutableSet = FluentIterable.from(this.allTypes).filter(TypeToken.TypeFilter.INTERFACE_ONLY).toSet();
      this.interfaces = localImmutableSet;
    }
    return localImmutableSet;
  }

  public TypeToken<T>.TypeSet interfaces()
  {
    return this;
  }

  public Set<Class<? super T>> rawTypes()
  {
    return FluentIterable.from(TypeToken.TypeCollector.FOR_RAW_TYPE.collectTypes(TypeToken.access$200(this.this$0))).filter(new Predicate()
    {
      public boolean apply(Class<?> paramAnonymousClass)
      {
        return paramAnonymousClass.isInterface();
      }
    }).toSet();
  }
}