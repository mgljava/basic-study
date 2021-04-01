package com.github.mgljava.basicstudy.designpattern.strategyall.shopping;

public class ShoppingCrashTest {

  public static void main(String[] args) {
    double normal = new ShoppingCrashContext("Return").getResult();
    System.out.println(normal);
  }
}
