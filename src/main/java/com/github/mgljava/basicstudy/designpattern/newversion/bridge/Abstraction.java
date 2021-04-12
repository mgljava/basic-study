package com.github.mgljava.basicstudy.designpattern.newversion.bridge;

public class Abstraction {

  // 持有实现对象
  protected Implementor implementor;

  public void setImplementor(Implementor implementor) {
    this.implementor = implementor;
  }

  public void operation() {
    implementor.operation();
  }
}
