package com.cjrequena.sample;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Util {

  public static BigDecimal round(BigDecimal value, BigDecimal increment, RoundingMode roundingMode) {
    /*
     * This method handles custom rounding to 0.05, and also sets the BigDecimal numbers to use 2 decimals
     *
     */
    if (increment.signum() == 0) {
      // 0 increment does not make much sense, but prevent division by 0
      return value;
    } else {
      BigDecimal divided = value.divide(increment, 0, roundingMode);
      BigDecimal result = divided.multiply(increment);
      result.setScale(2, RoundingMode.UNNECESSARY);
      return result;
    }
  }

  public double roundTwoDecimals(double d) {
    //A rounding method for double values to 2 decimals
    DecimalFormat twoDForm = new DecimalFormat("#.##");
    return Double.valueOf(twoDForm.format(d));
  }
}
