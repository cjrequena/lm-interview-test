package com.cjrequena.sample;

import lombok.NonNull;

import java.math.BigDecimal;

public class Medicine extends BasicTaxExemptProduct {
  public Medicine(@NonNull String name, @NonNull boolean imported, @NonNull BigDecimal price) {
    super(name, imported, price);
  }
}
