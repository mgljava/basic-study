package com.github.mgljava.basicstudy.designpattern.newversion.factory_method;

public class SubtractFactoryMethod implements FactoryMethod {

  @Override
  public CalcOperation getInstance() {
    return new SubtractCalcOperation();
  }
}
