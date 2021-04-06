package com.github.mgljava.basicstudy.designpattern.newversion.observer;

// 具体的主题或是具体的通知者
public class ConcreteSubject implements Subject {

  @Override
  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void deleteObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyAllObserver() {
    for (Observer observer : observers) {
      observer.update();
    }
  }
}
