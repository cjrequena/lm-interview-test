package com.cjrequena.sample;

import lombok.NonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NonBasicTaxExemptProduct extends Product {

  public NonBasicTaxExemptProduct(@NonNull String name, @NonNull boolean imported, @NonNull BigDecimal basePrice) {
    super(name, imported, basePrice);
  }

  public BigDecimal getTax() {
    BigDecimal importedTax = BigDecimal.ZERO;
    BigDecimal basicTax = CommonUtils.round(this.basePrice.multiply(Constants.BASIC_TAX), BigDecimal.valueOf(0.05), RoundingMode.UP);
    if (this.isImported()) {
      importedTax = CommonUtils.round(this.basePrice.multiply(Constants.IMPORTED_PRODUCT_TAX), BigDecimal.valueOf(0.05), RoundingMode.UP);
    }
    return basicTax.add(importedTax);
  }
}
