package com.github.mgljava.basicstudy.designpattern.newversion.simple_factory;

public class CalcSimpleFactory {

  public static CalcOperation getInstance(String operator) {
    switch (operator) {
      case "-":
        return new SubtractCalcOperation();
      default:
        return new AddCalcOperation();
    }
  }
}
