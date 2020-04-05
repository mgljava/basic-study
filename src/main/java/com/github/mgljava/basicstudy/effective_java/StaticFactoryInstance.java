package com.github.mgljava.basicstudy.effective_java;

/**
 * 1. 用静态方法工厂代替构造器
 */
public class StaticFactoryInstance {

  // 采用静态工厂方法生成类的实例
  public static StaticFactoryInstance createInstance() {
    return new StaticFactoryInstance();
  }
}
