package com.github.mgljava.basicstudy.designpattern.newversion.observer;

// 具体观察者1
public class ConcreteObserver1 implements Observer {

  @Override
  public void update() {
    System.out.println("ConcreteObserver1 方法得到调用");
  }
}
