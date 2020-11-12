package com.cjrequena.sample;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ReceiptTest {

  @InjectMocks
  private Receipt receipt;
  //
  private static Book book1;
  private static Other musicCd1;
  private static Food chocolateBar;
  //
  private static Food importedBoxOfChocolates;
  private static Other importedBottleOfPerfume1;

  //
  private static Other importedBottleOfPerfume2;
  private static Other bottlePerfume;
  private static Medicine packetOfHeadachePills;
  private static Food boxOfImportedChocolates;

  private static List<Product> products1;
  private static List<Product> products2;
  private static List<Product> products3;



  @BeforeAll
  @SuppressWarnings("unchecked")
  static void before() throws IOException {

    //
    book1 = new Book("Book",  false, BigDecimal.valueOf(12.49));
    musicCd1 = new Other("music CD", false, BigDecimal.valueOf(14.99));
    chocolateBar = new Food("chocolate bar", false, BigDecimal.valueOf(0.85));

    //
    importedBoxOfChocolates = new Food("imported box of chocolates", true, BigDecimal.valueOf(10));
    importedBottleOfPerfume1 = new Other("imported bottle of perfume", true, BigDecimal.valueOf(47.50));

    //
    importedBottleOfPerfume2 = new Other("Imported bottle of perfume", true, BigDecimal.valueOf(27.99));
    bottlePerfume = new Other("bottle of perfume", false, BigDecimal.valueOf(18.99));
    packetOfHeadachePills = new Medicine("packet of headache pills", false, BigDecimal.valueOf(9.75));
    boxOfImportedChocolates = new Food("box of imported chocolates",  true, BigDecimal.valueOf(11.25));

    products1 = Arrays.asList(book1,musicCd1,chocolateBar);
    products2 = Arrays.asList(importedBoxOfChocolates,importedBottleOfPerfume1);
    products3 = Arrays.asList(importedBottleOfPerfume2, bottlePerfume,packetOfHeadachePills,boxOfImportedChocolates);
  }

  @Test
  void calculatePriceAfterTaxesTest() {
    //
    assertEquals(BigDecimal.valueOf(12.49), receipt.calculatePriceAfterTaxes(book1));
    assertEquals(BigDecimal.valueOf(16.49), receipt.calculatePriceAfterTaxes(musicCd1));
    assertEquals(BigDecimal.valueOf(0.85), receipt.calculatePriceAfterTaxes(chocolateBar));

    //
    assertEquals(BigDecimal.valueOf(10.50).setScale(2), receipt.calculatePriceAfterTaxes(importedBoxOfChocolates));
    assertEquals(BigDecimal.valueOf(54.65), receipt.calculatePriceAfterTaxes(importedBottleOfPerfume1));

    //
    assertEquals(BigDecimal.valueOf(32.19), receipt.calculatePriceAfterTaxes(importedBottleOfPerfume2));
    assertEquals(BigDecimal.valueOf(20.89), receipt.calculatePriceAfterTaxes(bottlePerfume));
    assertEquals(BigDecimal.valueOf(9.75), receipt.calculatePriceAfterTaxes(packetOfHeadachePills));
    assertEquals(BigDecimal.valueOf(11.85).setScale(2), receipt.calculatePriceAfterTaxes(boxOfImportedChocolates));

  }

  @Test
  void calculateTotalPriceAfterTaxesTest() {
    assertEquals(BigDecimal.valueOf(29.83), receipt.calculateTotalPriceAfterTaxes(products1));
    assertEquals(BigDecimal.valueOf(65.15), receipt.calculateTotalPriceAfterTaxes(products2));
    assertEquals(BigDecimal.valueOf(74.68), receipt.calculateTotalPriceAfterTaxes(products3));
  }


  @Test
  void calculateTotalTaxTest() {
    assertEquals(BigDecimal.valueOf(1.50).setScale(2), receipt.calculateTotalTax(products1));
    assertEquals(BigDecimal.valueOf(7.65 ).setScale(2), receipt.calculateTotalTax(products2));
    assertEquals(BigDecimal.valueOf(6.70).setScale(2), receipt.calculateTotalTax(products3));
  }

}
