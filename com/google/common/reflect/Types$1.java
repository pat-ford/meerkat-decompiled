package com.google.common.reflect;

import com.google.common.base.Function;
import java.lang.reflect.Type;

final class Types$1
  implements Function<Type, String>
{
  public String apply(Type paramType)
  {
    return Types.JavaVersion.CURRENT.typeName(paramType);
  }
}