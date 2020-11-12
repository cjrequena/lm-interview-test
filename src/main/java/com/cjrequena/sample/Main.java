package com.cjrequena.sample;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] arg){
    ProductPriceCalculator productPriceCalculator = new ProductPriceCalculator();
    //
    Book book1 = new Book("Book",  false, BigDecimal.valueOf(12.49));
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
    productPriceCalculator.printReceipt(products1);
    productPriceCalculator.printReceipt(products2);
    productPriceCalculator.printReceipt(products3);



  }
}
