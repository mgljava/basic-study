package com.github.mgljava.basicstudy.designpattern.strategy_;

public class StrategyTest {

  public static void main(String[] args) {
    Context context = new Context(new Md5Strategy());
    context.encrypt();
  }
}
