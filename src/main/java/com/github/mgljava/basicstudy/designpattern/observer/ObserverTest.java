package com.github.mgljava.basicstudy.designpattern.observer;

public class ObserverTest {

  public static void main(String[] args) {
    Subject feed = new Feed();
    feed.registerObserver(new NYTimes());
    feed.registerObserver(new Guardian());
    feed.registerObserver(new LeMonde());

    feed.notifyObservers("queen Hello World!");
  }
}
