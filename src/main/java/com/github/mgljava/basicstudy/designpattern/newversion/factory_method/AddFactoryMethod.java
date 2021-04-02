package com.github.mgljava.basicstudy.designpattern.newversion.factory_method;

public class AddFactoryMethod implements FactoryMethod {

  @Override
  public CalcOperation getInstance() {
    return new AddCalcOperation();
  }
}
