package com.github.mgljava.basicstudy.designpattern.newversion.factory_method;

public class SubtractCalcOperation implements CalcOperation {

  @Override
  public double calculate(double numberA, double numberB) {
    return numberA - numberB;
  }
}
