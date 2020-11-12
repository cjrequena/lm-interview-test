package com.cjrequena.sample;

import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Log4j2
public class Main {
  public static void main(String[] arg){
    Receipt receipt = new Receipt();
    //
    Book book1 = new Book("book",  false, BigDecimal.valueOf(12.49));
    Other musicCd1 = new Other("music CD", false, BigDecimal.valueOf(14.99));
    Food chocolateBar = new Food("chocolate bar", false, BigDecimal.valueOf(0.85));

    //
    Food importedBoxOfChocolates = new Food("imported box of chocolates", true, BigDecimal.valueOf(10));
    Other importedBottleOfPerfume1 = new Other("imported bottle of perfume", true, BigDecimal.valueOf(47.50));

    //
    Other importedBottleOfPerfume2 = new Other("Imported bottle of perfume", true, BigDecimal.valueOf(27.99));
    Other bottlePerfume = new Other("bottle of perfume", false, BigDecimal.valueOf(18.99));
    Medicine packetOfHeadachePills = new Medicine("packet of headache pills", false, BigDecimal.valueOf(9.75));
    Food boxOfImportedChocolates = new Food("box of imported chocolates",  true, BigDecimal.valueOf(11.25));

    //
    List<Product> products1 = Arrays.asList(book1,musicCd1,chocolateBar);
    List<Product> products2 = Arrays.asList(importedBoxOfChocolates,importedBottleOfPerfume1);
    List<Product> products3 = Arrays.asList(importedBottleOfPerfume2, bottlePerfume,packetOfHeadachePills,boxOfImportedChocolates);

    //
    log.info("Input 1");
    receipt.printReceiptInput(products1);
    log.info("Output 1");
    receipt.printReceiptOutput(products1);
    log.info("Input 2");
    receipt.printReceiptInput(products2);
    log.info("Output 2");
    receipt.printReceiptOutput(products2);
    log.info("Input 3");
    receipt.printReceiptInput(products3);
    log.info("Output 3");
    receipt.printReceiptOutput(products3);

  }
}
