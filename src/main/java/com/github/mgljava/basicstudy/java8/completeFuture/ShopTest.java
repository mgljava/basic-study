package com.github.mgljava.basicstudy.java8.completeFuture;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ShopTest {

  public static void main(String[] args) {

    Shop shop = new Shop("");

    long start = System.nanoTime();
    Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
    long invocationTime = ((System.nanoTime() - start) / 1_000_000);
    System.out.println("Invocation returned after " + invocationTime
        + " msecs");
    System.out.println("do someThing ... ");
    try {
      double price = futurePrice.get(200, TimeUnit.SECONDS);
      System.out.printf("Price is %.2f%n", price);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
    System.out.println("Price returned after " + retrievalTime + " msecs");
  }
}
