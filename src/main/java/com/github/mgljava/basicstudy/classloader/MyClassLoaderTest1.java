package com.github.mgljava.basicstudy.classloader;

public class MyClassLoaderTest1 {

  public static void main(String[] args) throws Exception {

    Class<?> clazz = Class.forName("java.lang.Integer");
    System.out.println(clazz.getClassLoader());

    Class<?> aClass = Class.forName("com.github.mgljava.basicstudy.classloader.C");
    System.out.println(aClass.getClassLoader());

    Class<?> aClass1 = Class.forName("java.util.ArrayList");
    System.out.println(aClass1.getClassLoader());
  }
}

class C {

}