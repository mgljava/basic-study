package com.github.mgljava.basicstudy.jvm.classloader;

class CL {
  static int a = 10;
  static {
    System.out.println("Class CL");
  }
}

// 调用ClassLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致初始化。

public class MyTest12 {

  public static void main(String[] args) throws ClassNotFoundException {

    ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
    Class<?> aClass = systemClassLoader.loadClass("com.github.mgljava.basicstudy.jvm.classloader.CL");
    System.out.println(aClass);
    System.out.println("---------------");
    Class<?> aClass1 = Class.forName("com.github.mgljava.basicstudy.jvm.classloader.CL");// 反射，对类的主动使用
    System.out.println(CL.a);
    System.out.println(aClass1);
  }
}
