package com.github.mgljava.basicstudy.designpattern.newversion.simple_factory;

public class MainTest {

  public static void main(String[] args) {
    CalcOperation calcOperation = CalcSimpleFactory.getInstance("+");
    double addResult = calcOperation.calculate(10D, 20D);
    System.out.println(addResult);

    CalcOperation subCalcOperation = CalcSimpleFactory.getInstance("-");
    double subResult = subCalcOperation.calculate(100D, 20D);
    System.out.println(subResult);
  }
}
