package com.cjrequena.sample;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
public class Product {

  @NonNull
  protected String name;

  @NonNull
  protected boolean imported;

  @NonNull
  protected boolean taxExempt;

  @NonNull
  protected BigDecimal basePrice;

  public  BigDecimal getTax(){
    BigDecimal importedTax = BigDecimal.ZERO;
    BigDecimal basicTax = BigDecimal.ZERO;
    if (this.isImported()) {
      importedTax = CommonUtils.round(this.basePrice.multiply(Constants.IMPORTED_PRODUCT_TAX), BigDecimal.valueOf(0.05), RoundingMode.UP);
    }
    if(!this.taxExempt){
      basicTax = CommonUtils.round(this.basePrice.multiply(Constants.BASIC_TAX), BigDecimal.valueOf(0.05), RoundingMode.UP);
    }
    return basicTax.add(importedTax);
  }


}
