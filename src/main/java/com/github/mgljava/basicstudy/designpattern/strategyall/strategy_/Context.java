package com.github.mgljava.basicstudy.designpattern.strategyall.strategy_;

// 策略模式对象的引用持有者
public class Context {

  private final Strategy strategy;

  public Context(Strategy strategy) {
    this.strategy = strategy;
  }

  public void encrypt() {
    this.strategy.encrypt();
  }
}
