package com.github.mgljava.basicstudy.designpattern.singleton.other;

import java.lang.reflect.Constructor;

public class LazySingleton2Test {

  public static void main(String[] args) {

    LazySingleton2 instance1 = LazySingleton2.getInstance();

    LazySingleton2 instance2 = null;

    try {
      Class<LazySingleton2> clazz = LazySingleton2.class;
      Constructor<LazySingleton2> constructor = clazz.getDeclaredConstructor();
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