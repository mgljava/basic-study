package com.github.mgljava.basicstudy.designpattern.newversion.decorator;

public class MainTest {

  public static void main(String[] args) {
    ConcreteComponent concreteComponent = new ConcreteComponent();

    ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA();
    ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB();

    /**
     * 装饰过程
     */
    concreteDecoratorA.setComponent(concreteComponent);
    concreteDecoratorB.setComponent(concreteDecoratorA);

    concreteDecoratorB.operation();
  }
}
