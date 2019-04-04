package com.github.mgljava.basicstudy.designpattern.facade;

/**
 * 外观模式：为子系统中的一组接口提供一个一致的界面，Facade模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
 */
public class MainTest {

  public static void main(String[] args) {

    ServiceA serviceA = new ServiceAImpl();
    serviceA.serviceA();

    System.out.println("-----------------------");

    Facade facade = new Facade();
    facade.methodA();
    facade.methodB();

  }
}
