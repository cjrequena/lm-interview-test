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
    BigDecimal total = BigDecimal.ZERO;
    for (Product product : products) {
      total = total.add(calculatePriceAfterTaxes(product));
    }
    return total;
  }

  public BigDecimal calculateTotalTax(List<Product> products) {
    BigDecimal total = BigDecimal.ZERO;
    for (Product product : products) {
      total = total.add(product.getTax());
    }
    return total;
  }

  public void printReceipt(List<Product> products) {

    StringBuffer input = new StringBuffer("INPUT").append("\n");
    StringBuffer output= new StringBuffer("OUTPUT").append("\n");
    for (Product product : products) {
      input.append("1 " + product.getName() + " at " + product.getBasePrice()).append("\n");
      output.append("1 " + product.getName() + " : " + calculatePriceAfterTaxes(product)).append("\n");
    }
    System.out.println(input.toString());
    System.out.println(output.toString());
    System.out.printf("Sales Tax: %.2f\n", calculateTotalTax(products));
    System.out.printf("Total: %.2f\n", calculateTotalPriceAfterTaxes(products));
    System.out.println(" ");
  }
}
