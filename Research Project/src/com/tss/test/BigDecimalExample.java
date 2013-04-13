package com.tss.test;

import java.math.BigDecimal;

public class BigDecimalExample {

  public static void main(String argv[]) {
    BigDecimal first = new BigDecimal("5.23343");
    BigDecimal second = new BigDecimal("2.0");
    System.out.println(first.add(second));
    System.out.println("first ="+first);
    System.out.println(first.subtract(second));
    System.out.println(first.divide(second));
    System.out.println(first.equals(second));
    System.out.println(first.abs());
    System.out.println(first.max(second));
    System.out.println(first.min(second));
    System.out.println(first.remainder(second));
  }
}
