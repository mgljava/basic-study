package com.github.mgljava.basicstudy.designpattern.factory.abstract_factory;

public class IosFactory implements SystemFactory {

  @Override
  public OperationController createOperationController() {
    return new IosOperationController();
  }

  @Override
  public UIController createInterfaceController() {
    return new IosUIController();
  }
}
