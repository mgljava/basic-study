package com.github.mgljava.basicstudy.designpattern.proxy.staticproxy;

public class TestCount {

  public static void main(String[] args) {
    CountImpl count = new CountImpl();
    CountProxy countProxy = new CountProxy(count);
    countProxy.queryCount();
    countProxy.updateCount();
  }
}
