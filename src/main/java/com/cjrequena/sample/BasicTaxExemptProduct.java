package com.cjrequena.sample;

import lombok.NonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BasicTaxExemptProduct extends Product{
  public BasicTaxExemptProduct(@NonNull String name, @NonNull boolean imported, @NonNull BigDecimal basePrice) {
    super(name, imported, basePrice);
  }

  public BigDecimal getTax() {
    if (this.isImported()) {
      return CommonUtils.round(this.basePrice.multiply(Constants.IMPORTED_PRODUCT_TAX), BigDecimal.valueOf(0.05), RoundingMode.UP);
    }
    return BigDecimal.ZERO;
  }
}
