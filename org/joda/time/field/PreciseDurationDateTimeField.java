package org.joda.time.field;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public abstract class PreciseDurationDateTimeField extends BaseDateTimeField
{
  private static final long serialVersionUID = 5004523158306266035L;
  private final DurationField iUnitField;
  final long iUnitMillis;

  public PreciseDurationDateTimeField(DateTimeFieldType paramDateTimeFieldType, DurationField paramDurationField)
  {
    super(paramDateTimeFieldType);
    if (!paramDurationField.isPrecise())
      throw new IllegalArgumentException("Unit duration field must be precise");
    this.iUnitMillis = paramDurationField.getUnitMillis();
    if (this.iUnitMillis < 1L)
      throw new IllegalArgumentException("The unit milliseconds must be at least 1");
    this.iUnitField = paramDurationField;
  }

  public DurationField getDurationField()
  {
    return this.iUnitField;
  }

  protected int getMaximumValueForSet(long paramLong, int paramInt)
  {
    return getMaximumValue(paramLong);
  }

  public int getMinimumValue()
  {
    return 0;
  }

  public final long getUnitMillis()
  {
    return this.iUnitMillis;
  }

  public boolean isLenient()
  {
    return false;
  }

  public long remainder(long paramLong)
  {
    if (paramLong >= 0L)
      return paramLong % this.iUnitMillis;
    return (paramLong + 1L) % this.iUnitMillis + this.iUnitMillis - 1L;
  }

  public long roundCeiling(long paramLong)
  {
    if (paramLong > 0L)
    {
      long l = paramLong - 1L;
      return l - l % this.iUnitMillis + this.iUnitMillis;
    }
    return paramLong - paramLong % this.iUnitMillis;
  }

  public long roundFloor(long paramLong)
  {
    if (paramLong >= 0L)
      return paramLong - paramLong % this.iUnitMillis;
    long l = 1L + paramLong;
    return l - l % this.iUnitMillis - this.iUnitMillis;
  }

  public long set(long paramLong, int paramInt)
  {
    FieldUtils.verifyValueBounds(this, paramInt, getMinimumValue(), getMaximumValueForSet(paramLong, paramInt));
    return paramLong + (paramInt - get(paramLong)) * this.iUnitMillis;
  }
}