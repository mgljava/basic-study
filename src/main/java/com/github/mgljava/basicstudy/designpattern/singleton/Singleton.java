package com.github.mgljava.basicstudy.designpattern.singleton;

/**
 * author: SweepMonk
 * 2018年9月10日22:02:28
 */
public class Singleton {

  private static Singleton singleton = new Singleton();

  private Singleton() {

  }

  public static Singleton getInstance() {
    return singleton;
  }
}
