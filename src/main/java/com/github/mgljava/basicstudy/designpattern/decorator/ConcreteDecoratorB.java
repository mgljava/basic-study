package com.github.mgljava.basicstudy.designpattern.decorator;

/**
 * 具体的装饰对象
 */
public class ConcreteDecoratorB extends Decorator {

  @Override
  void operation() {
    super.operation();
    addBehavior();
    System.out.println("具体的装饰B对象的操作");
  }

  private void addBehavior() {
    System.out.println("ConcreteDecoratorB -> addBehavior");
  }
}
