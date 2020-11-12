package com.cjrequena.sample;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CommonUtils {

  private CommonUtils() {
    throw new IllegalStateException("Utility class");
  }

  public static BigDecimal round(BigDecimal value, BigDecimal increment, RoundingMode roundingMode) {
    if (increment.signum() == 0) {
      return value;
    } else {
      BigDecimal divided = value.divide(increment, 0, roundingMode);
      BigDecimal result = divided.multiply(increment);
      result = result.setScale(2, RoundingMode.UNNECESSARY);
      return result;
    }
  }
}
