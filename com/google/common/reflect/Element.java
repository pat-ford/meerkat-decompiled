package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import javax.annotation.Nullable;

class Element extends AccessibleObject
  implements Member
{
  private final AccessibleObject accessibleObject;
  private final Member member;

  <M extends AccessibleObject,  extends Member> Element(M paramM)
  {
    Preconditions.checkNotNull(paramM);
    this.accessibleObject = paramM;
    this.member = ((Member)paramM);
  }

  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool1 = paramObject instanceof Element;
    boolean bool2 = false;
    if (bool1)
    {
      Element localElement = (Element)paramObject;
      boolean bool3 = getOwnerType().equals(localElement.getOwnerType());
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = this.member.equals(localElement.member);
        bool2 = false;
        if (bool4)
          bool2 = true;
      }
    }
    return bool2;
  }

  public final <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    return this.accessibleObject.getAnnotation(paramClass);
  }

  public final Annotation[] getAnnotations()
  {
    return this.accessibleObject.getAnnotations();
  }

  public final Annotation[] getDeclaredAnnotations()
  {
    return this.accessibleObject.getDeclaredAnnotations();
  }

  public Class<?> getDeclaringClass()
  {
    return this.member.getDeclaringClass();
  }

  public final int getModifiers()
  {
    return this.member.getModifiers();
  }

  public final String getName()
  {
    return this.member.getName();
  }

  public TypeToken<?> getOwnerType()
  {
    return TypeToken.of(getDeclaringClass());
  }

  public int hashCode()
  {
    return this.member.hashCode();
  }

  public final boolean isAbstract()
  {
    return Modifier.isAbstract(getModifiers());
  }

  public final boolean isAccessible()
  {
    return this.accessibleObject.isAccessible();
  }

  public final boolean isAnnotationPresent(Class<? extends Annotation> paramClass)
  {
    return this.accessibleObject.isAnnotationPresent(paramClass);
  }

  public final boolean isFinal()
  {
    return Modifier.isFinal(getModifiers());
  }

  public final boolean isNative()
  {
    return Modifier.isNative(getModifiers());
  }

  public final boolean isPackagePrivate()
  {
    return (!isPrivate()) && (!isPublic()) && (!isProtected());
  }

  public final boolean isPrivate()
  {
    return Modifier.isPrivate(getModifiers());
  }

  public final boolean isProtected()
  {
    return Modifier.isProtected(getModifiers());
  }

  public final boolean isPublic()
  {
    return Modifier.isPublic(getModifiers());
  }

  public final boolean isStatic()
  {
    return Modifier.isStatic(getModifiers());
  }

  public final boolean isSynchronized()
  {
    return Modifier.isSynchronized(getModifiers());
  }

  public final boolean isSynthetic()
  {
    return this.member.isSynthetic();
  }

  final boolean isTransient()
  {
    return Modifier.isTransient(getModifiers());
  }

  final boolean isVolatile()
  {
    return Modifier.isVolatile(getModifiers());
  }

  public final void setAccessible(boolean paramBoolean)
    throws SecurityException
  {
    this.accessibleObject.setAccessible(paramBoolean);
  }

  public String toString()
  {
    return this.member.toString();
  }
}