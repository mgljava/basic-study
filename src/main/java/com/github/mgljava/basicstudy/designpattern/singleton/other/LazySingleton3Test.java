package com.github.mgljava.basicstudy.designpattern.singleton.other;

import java.lang.reflect.Constructor;

/**
 * 加入flag来校验
 */
public class LazySingleton3Test {

  public static void main(String[] args) {

    LazySingleton3 instance1 = LazySingleton3.getInstance();

    LazySingleton3 instance2 = null;

    try {
      Class<LazySingleton3> clazz = LazySingleton3.class;
      Constructor<LazySingleton3> constructor = clazz.getDeclaredConstructor();
      constructor.setAccessible(true);
      instance2 = constructor.newInstance();
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println(instance1.hashCode());
    assert instance2 != null;
    System.out.println(instance2.hashCode());
  }
}
