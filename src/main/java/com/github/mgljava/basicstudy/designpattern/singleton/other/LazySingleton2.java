package com.github.mgljava.basicstudy.designpattern.singleton.other;

/**
 * 根据类的加载的依据：
 * 1.加载一个类时，其内部类不会同时被加载
 * 2.一个类的加载，当且仅当其类的静态成员（静态域，构造器，静态方法等）被调用时发生。
 */
public class LazySingleton2 {

  private LazySingleton2() {
  }

  static class SingletonHolder {

    private static LazySingleton2 lazySingleton2 = new LazySingleton2();
  }

  public static LazySingleton2 getInstance() {
    return SingletonHolder.lazySingleton2;
  }
}
