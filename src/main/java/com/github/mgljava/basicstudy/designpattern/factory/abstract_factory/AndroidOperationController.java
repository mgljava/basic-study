package com.github.mgljava.basicstudy.designpattern.factory.abstract_factory;

public class AndroidOperationController implements OperationController {

  @Override
  public void control() {
    System.out.println("AndroidOperationController");
  }
}
