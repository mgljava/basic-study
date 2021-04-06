package com.github.mgljava.basicstudy.designpattern.newversion.facade;

public class Facade {

  private final ServiceA serviceA;
  private final ServiceB serviceB;

  public Facade() {
    serviceA = new ServiceAImpl();
    serviceB = new ServiceBImpl();
  }

  // 门面方法1，可以任意组装调用，客户端不必知道由哪些方法组成的
  public void methodA() {
    serviceA.serviceA();
    serviceB.serviceB();
  }

  // 门面方法2
  public void methodB() {
    serviceB.serviceB();
    serviceA.serviceA();
  }
}
