package com.github.mgljava.basicstudy.designpattern.newversion.bridge;

public class MainTest {

  public static void main(String[] args) {
    RefinedAbstraction refinedAbstraction = new RefinedAbstraction();
    refinedAbstraction.setImplementor(new ConcreteImplementorA());
    refinedAbstraction.operation();

    refinedAbstraction.setImplementor(new ConcreteImplementorB());
    refinedAbstraction.operation();

  }
}
