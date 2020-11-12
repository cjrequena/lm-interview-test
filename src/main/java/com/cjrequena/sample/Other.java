package com.cjrequena.sample;

import lombok.NonNull;

import java.math.BigDecimal;

public class Other extends NonBasicTaxExemptProduct {
  public Other(@NonNull String name, @NonNull boolean imported, @NonNull BigDecimal price) {
    super(name, imported, price);
  }
}
