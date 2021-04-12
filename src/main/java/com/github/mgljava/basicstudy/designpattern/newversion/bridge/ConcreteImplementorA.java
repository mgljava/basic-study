package com.github.mgljava.basicstudy.designpattern.newversion.bridge;

public class ConcreteImplementorA implements Implementor{

  @Override
  public void operation() {
    System.out.println("ConcreteImplementorA 方法的具体操作");
  }
}
