package com.cjrequena.sample;

import lombok.NonNull;

import java.math.BigDecimal;

public class Book extends BasicTaxExemptProduct {
  public Book(@NonNull String name, @NonNull boolean imported, @NonNull BigDecimal price) {
    super(name, imported, price);
  }
}
