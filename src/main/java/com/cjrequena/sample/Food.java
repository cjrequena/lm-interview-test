package com.cjrequena.sample;

import lombok.NonNull;

import java.math.BigDecimal;

public class Food extends BasicTaxExemptProduct {

  public Food(@NonNull String name, @NonNull boolean imported, @NonNull BigDecimal basePrice) {
    super(name, imported, basePrice);
  }
}
