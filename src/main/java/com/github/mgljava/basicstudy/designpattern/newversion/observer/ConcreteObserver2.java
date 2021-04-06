package com.github.mgljava.basicstudy.designpattern.newversion.observer;

// 具体观察者2
public class ConcreteObserver2 implements Observer {

  @Override
  public void update() {
    System.out.println("ConcreteObserver2 方法得到调用");
  }
}
