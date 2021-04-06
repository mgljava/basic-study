package com.github.mgljava.basicstudy.designpattern.newversion.facade;

public class Facade {

  private ServiceA serviceA;
  private ServiceB serviceB;

  public Facade() {
    serviceA = new ServiceAImpl();
    serviceB = new ServiceBImpl();
  }

  public void methodA() {
    serviceA.serviceA();
    serviceB.serviceB();
  }

  public void methodB() {
    serviceB.serviceB();
    serviceA.serviceA();
  }
}
