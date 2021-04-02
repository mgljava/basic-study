package com.github.mgljava.basicstudy.designpattern.newversion.factory_method;

public class MainTest {

  public static void main(String[] args) {
    FactoryMethod factoryMethod = new AddFactoryMethod();
    double addResult = factoryMethod.getInstance().calculate(10D, 30D);
    System.out.println(addResult);

    FactoryMethod subtractFactoryMethod = new SubtractFactoryMethod();
    double subResult = subtractFactoryMethod.getInstance().calculate(90D, 28D);
    System.out.println(subResult);
  }
}
