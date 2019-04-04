package com.github.mgljava.basicstudy.designpattern.strategy.case2;

public class LambdaStrategyTest {

  public static void main(String[] args) {

    ValidationStrategy stringStrategy = string -> string.matches("[a-z]*");
    System.out.println(stringStrategy.execute("aaa11"));

    ValidationStrategy numberStrategy = (string) -> string.matches("\\d*");
    System.out.println(numberStrategy.execute("123"));
  }
}
