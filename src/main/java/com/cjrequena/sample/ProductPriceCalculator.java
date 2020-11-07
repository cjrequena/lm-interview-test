package com.cjrequena.sample;

import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.util.List;

@Log4j2
public class ProductPriceCalculator {

  public BigDecimal calculatePriceAfterTaxes(Product product) {
    return product.getBasePrice().add(product.getTax());
  }

  public BigDecimal calculateTotalPriceAfterTaxes(List<Product> products) {
   return null;
  }

  public BigDecimal calculateTotalTax(List<Product> products) {
    return null;

  }

  public void printReceipt(List<Product> products) {

  }
}
