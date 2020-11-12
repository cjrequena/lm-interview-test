package com.cjrequena.sample;

import java.math.BigDecimal;

public class Constants {

  private Constants() {
    throw new IllegalStateException("Constants class");
  }

  public static final BigDecimal BASIC_TAX = BigDecimal.valueOf(0.10).setScale(2);
  public static final BigDecimal IMPORTED_PRODUCT_TAX = BigDecimal.valueOf(0.05).setScale(2);
}
