package com.github.mgljava.basicstudy.designpattern.observer;

import java.util.Vector;

public class Feed implements Subject {

  private final Vector<Observer> observers = new Vector<>();

  @Override
  public void registerObserver(Observer o) {
    observers.add(o);
  }

  @Override
  public void notifyObservers(String tweet) {
    observers.forEach(observer -> observer.notify(tweet));
  }
}
