package com.github.mgljava.basicstudy.designpattern.decorator;

/**
 * 具体的装饰对象
 */
public class ConcreteDecoratorA extends Decorator {

  private String addStatus;

  @Override
  void operation() {
    super.operation();
    addStatus = "new Status";
    System.out.println("具体的装饰对象A的操作，addStatus:" + addStatus);
  }
}
