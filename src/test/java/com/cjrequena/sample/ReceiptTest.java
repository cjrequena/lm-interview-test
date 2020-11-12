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
  private static Product book1;
  private static Product musicCd1;
  private static Product chocolateBar;
  //
  private static Product importedBoxOfChocolates;
  private static Product importedBottleOfPerfume1;

  //
  private static Product importedBottleOfPerfume2;
  private static Product bottlePerfume;
  private static Product packetOfHeadachePills;
  private static Product boxOfImportedChocolates;

  private static List<Product> products1;
  private static List<Product> products2;
  private static List<Product> products3;



  @BeforeAll
  @SuppressWarnings("unchecked")
  static void before() throws IOException {

    //
    book1 = new Product("Book",  false,true, BigDecimal.valueOf(12.49));
    musicCd1 = new Product("music CD", false, false,BigDecimal.valueOf(14.99));
    chocolateBar = new Product("chocolate bar", false,true, BigDecimal.valueOf(0.85));

    //
    importedBoxOfChocolates = new Product("imported box of chocolates", true,true, BigDecimal.valueOf(10));
    importedBottleOfPerfume1 = new Product("imported bottle of perfume", true,false, BigDecimal.valueOf(47.50));

    //
    importedBottleOfPerfume2 = new Product("Imported bottle of perfume", true, false,BigDecimal.valueOf(27.99));
    bottlePerfume = new Product("bottle of perfume", false, false,BigDecimal.valueOf(18.99));
    packetOfHeadachePills = new Product("packet of headache pills", false, true,BigDecimal.valueOf(9.75));
    boxOfImportedChocolates = new Product("box of imported chocolates",  true, true,BigDecimal.valueOf(11.25));

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
