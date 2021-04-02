package com.github.mgljava.basicstudy.designpattern.newversion.simple_factory;

public class AddCalcOperation implements CalcOperation {

  @Override
  public double calculate(double numberA, double numberB) {
    return numberA + numberB;
  }
}
