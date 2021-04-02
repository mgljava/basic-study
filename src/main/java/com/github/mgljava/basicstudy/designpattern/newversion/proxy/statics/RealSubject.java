package com.github.mgljava.basicstudy.designpattern.newversion.proxy.statics;

public class RealSubject implements Subject {

  @Override
  public void sayHello() {
    System.out.println("真实对象sayHello");
  }
}
