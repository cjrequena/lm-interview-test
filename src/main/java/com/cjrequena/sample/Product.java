package com.cjrequena.sample;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public abstract class Product {

  @NonNull
  protected String name;

  @NonNull
  protected boolean imported;

  @NonNull
  protected BigDecimal basePrice;

  public abstract BigDecimal getTax();


}
