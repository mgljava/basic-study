package com.github.mgljava.basicstudy.designpattern.newversion.bridge;

public class ConcreteImplementorB implements Implementor {

  @Override
  public void operation() {
    System.out.println("ConcreteImplementorB 方法的具体操作");
  }
}
