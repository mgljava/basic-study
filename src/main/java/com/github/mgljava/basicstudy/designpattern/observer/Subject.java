package com.github.mgljava.basicstudy.designpattern.observer;

public interface Subject {

  void registerObserver(Observer o);

  void notifyObservers(String tweet);
}
