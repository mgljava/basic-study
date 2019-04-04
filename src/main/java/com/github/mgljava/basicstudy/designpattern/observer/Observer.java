package com.github.mgljava.basicstudy.designpattern.observer;

/**
 * 观察者接口，它将不同的观察者聚合在一起.
 */
public interface Observer {

  void notify(String tweet);
}
