package com.github.mgljava.basicstudy.designpattern.newversion.factory_method;

public class AddCalcOperation implements CalcOperation {

  @Override
  public double calculate(double numberA, double numberB) {
    return numberA + numberB;
  }
}
