package com.github.mgljava.basicstudy.designpattern.factory.abstract_factory;

public class WpOperationController implements OperationController {

  @Override
  public void control() {
    System.out.println("WpOperationController");
  }
}
