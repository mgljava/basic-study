package com.github.mgljava.basicstudy.designpattern.newversion.bridge;

public class RefinedAbstraction extends Abstraction {

  @Override
  public void operation() {
    implementor.operation();
  }
}
