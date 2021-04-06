package com.github.mgljava.basicstudy.designpattern.newversion.observer;

public class MainTest {

  public static void main(String[] args) {
    Subject subject = new ConcreteSubject();
    subject.addObserver(new ConcreteObserver1());
    subject.addObserver(new ConcreteObserver2());

    // 当主题发生变化，通知观察者
    subject.notifyAllObserver();
  }
}
