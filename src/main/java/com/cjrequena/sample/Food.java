package com.cjrequena.sample;

import lombok.NonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Food extends Product {
  public Food(@NonNull String name, @NonNull boolean imported, @NonNull BigDecimal price) {
    super(name, imported, price);
  }

  public BigDecimal getTax() {
    if (this.isImported()) {
      return Util.round(this.basePrice.multiply(Constants.IMPORTED_PRODUCT_TAX), BigDecimal.valueOf(0.05), RoundingMode.UP);
    }
    return BigDecimal.ZERO;
  }


  public EProductType getProductType() {
    return EProductType.FOOD;
  }
}
