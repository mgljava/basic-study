package com.github.mgljava.basicstudy.designpattern.singleton.other;

import java.io.Serializable;

/**
 * 加入flag来校验
 */
public class LazySingleton3 implements Serializable {

  private static boolean initialized = false;

  private LazySingleton3() {
    synchronized (LazySingleton3.class) {
      if (!initialized) {
        initialized = true;
      } else {
        throw new RuntimeException("单例已被破坏");
      }
    }
  }

  private static class SingletonHolder {

    private static final LazySingleton3 instance = new LazySingleton3();
  }

  public static LazySingleton3 getInstance() {
    return SingletonHolder.instance;
  }
}
