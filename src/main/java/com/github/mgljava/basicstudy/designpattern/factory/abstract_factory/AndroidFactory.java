package com.github.mgljava.basicstudy.designpattern.factory.abstract_factory;

public class AndroidFactory implements SystemFactory {

  @Override
  public OperationController createOperationController() {
    return new AndroidOperationController();
  }

  @Override
  public UIController createInterfaceController() {
    return new AndroidUIController();
  }
}
