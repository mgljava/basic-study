package com.github.mgljava.basicstudy.jvm.classloader;

// 类加载器
public class MyTest13 {

  public static void main(String[] args) {
    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    System.out.println(classLoader);
    while (classLoader != null) {
      classLoader = classLoader.getParent();
      System.out.println(classLoader);
    }
  }
}
