package com.github.mgljava.basicstudy.designpattern.newversion.strategyall.shopping;

public class ShoppingCrashContext {

  private ShoppingCrash shoppingCrash = null;

  public ShoppingCrashContext(String type) {
    switch (type) {
      case "Normal":
        shoppingCrash = new ShoppingCrashNormal();
        break;
      case "Return":
        shoppingCrash = new ShoppingCrashReturn();
        break;
    }
  }

  public double getResult() {
    return shoppingCrash.acceptCrash();
  }
}
