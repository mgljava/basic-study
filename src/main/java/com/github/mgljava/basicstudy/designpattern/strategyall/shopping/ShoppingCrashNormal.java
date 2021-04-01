package com.github.mgljava.basicstudy.designpattern.strategyall.shopping;

public class ShoppingCrashNormal implements ShoppingCrash {

  @Override
  public double acceptCrash() {
    System.out.println("正常算法");
    return 0;
  }
}
