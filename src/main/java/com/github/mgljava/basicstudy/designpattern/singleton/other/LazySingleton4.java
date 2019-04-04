package com.github.mgljava.basicstudy.designpattern.singleton.other;

import java.io.Serializable;

public class LazySingleton4 implements Serializable {

  private static boolean initialized = false;

  private LazySingleton4() {
    synchronized (LazySingleton4.class) {
      if (!initialized) {
        initialized = true;
      } else {
        throw new RuntimeException("单例已被破坏");
      }
    }
  }

  private static class SingletonHolder {

    private static final LazySingleton4 instance = new LazySingleton4();
  }

  public static LazySingleton4 getInstance() {
    return SingletonHolder.instance;
  }

  private Object readResolve() {
    return getInstance();
  }
}
