package com.github.mgljava.basicstudy.designpattern.newversion.strategyall.shopping;

public class ShoppingCrashReturn implements ShoppingCrash {

  @Override
  public double acceptCrash() {
    System.out.println("满多少返一半的活动");
    return 0;
  }
}
