package com.cjrequena.sample;

import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Log4j2
public class Main {
  public static void main(String[] arg) {
    Receipt receipt = new Receipt();
    //
    Product book1 = new Product("book", false, true, BigDecimal.valueOf(12.49));
    Product musicCd1 = new Product("music CD", false, false, BigDecimal.valueOf(14.99));
    Product chocolateBar = new Product("chocolate bar", false, true, BigDecimal.valueOf(0.85));
    //
    Product importedBoxOfChocolates = new Product("imported box of chocolates", true, true, BigDecimal.valueOf(10));
    Product importedBottleOfPerfume1 = new Product("imported bottle of perfume", true, false, BigDecimal.valueOf(47.50));

    //
    Product importedBottleOfPerfume2 = new Product("Imported bottle of perfume", true, false, BigDecimal.valueOf(27.99));
    Product bottlePerfume = new Product("bottle of perfume", false, false, BigDecimal.valueOf(18.99));
    Product packetOfHeadachePills = new Product("packet of headache pills", false, true, BigDecimal.valueOf(9.75));
    Product boxOfImportedChocolates = new Product("box of imported chocolates", true, true, BigDecimal.valueOf(11.25));

    //
    List<Product> products1 = Arrays.asList(book1, musicCd1, chocolateBar);
    List<Product> products2 = Arrays.asList(importedBoxOfChocolates, importedBottleOfPerfume1);
    List<Product> products3 = Arrays.asList(importedBottleOfPerfume2, bottlePerfume, packetOfHeadachePills, boxOfImportedChocolates);

    //
    log.info("Input 1");
    receipt.printReceiptInput(products1);
    log.info("Output 1");
    receipt.printReceiptOutput2(products1);
    log.info("Input 2");
    receipt.printReceiptInput(products2);
    log.info("Output 2");
    receipt.printReceiptOutput2(products2);
    log.info("Input 3");
    receipt.printReceiptInput(products3);
    log.info("Output 3");
    receipt.printReceiptOutput2(products3);

  }
}
