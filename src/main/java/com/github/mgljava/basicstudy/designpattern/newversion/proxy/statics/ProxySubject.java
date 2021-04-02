package com.github.mgljava.basicstudy.designpattern.newversion.proxy.statics;

public class ProxySubject implements Subject {

  private final RealSubject subject;

  public ProxySubject() {
    this.subject = new RealSubject();
  }

  @Override
  public void sayHello() {
    subject.sayHello();
    this.sayWorld();
    System.out.println("代理对象SayHello");
  }

  private void sayWorld() {
    System.out.println("代理对象sayWorld");
  }
}
