package com.cjrequena.sample;

import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.util.List;

@Log4j2
public class Receipt {

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

  public void printReceiptOutput(List<Product> products) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < products.size(); i++) {
      if (i == products.size()-1) {
        sb.append("1 " + products.get(i).getName() + " : " + calculatePriceAfterTaxes(products.get(i)));
      }else{
        sb.append("1 " + products.get(i).getName() + " : " + calculatePriceAfterTaxes(products.get(i))).append("\n");
      }
    }
    log.info(sb.toString());
    log.info("Sales Tax: {}", calculateTotalTax(products));
    log.info("Total: {}\n", calculateTotalPriceAfterTaxes(products));
    log.info(" ");
  }

  // This way it iterates less on the product list.
  public void printReceiptOutput2(List<Product> products) {
    BigDecimal totalPriceAfterTaxes = BigDecimal.ZERO;
    BigDecimal totalTax = BigDecimal.ZERO;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < products.size(); i++) {
      if (i == products.size()-1) {
        sb.append("1 " + products.get(i).getName() + " : " + calculatePriceAfterTaxes(products.get(i)));
      }else{
        sb.append("1 " + products.get(i).getName() + " : " + calculatePriceAfterTaxes(products.get(i))).append("\n");
      }
      totalTax = totalTax.add(products.get(i).getTax());
      totalPriceAfterTaxes = totalPriceAfterTaxes.add(calculatePriceAfterTaxes(products.get(i)));
    }
    log.info(sb.toString());
    log.info("Sales Tax: {}", totalTax);
    log.info("Total: {}\n", totalPriceAfterTaxes);
    log.info(" ");
  }


  public void printReceiptInput(List<Product> products) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < products.size(); i++) {
      sb.append("1 " + products.get(i).getName() + " at " + products.get(i).getBasePrice()).append("\n");
    }
    log.info(sb.toString());
  }
}
