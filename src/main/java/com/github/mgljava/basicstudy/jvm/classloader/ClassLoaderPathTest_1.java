package com.github.mgljava.basicstudy.jvm.classloader;

/**
 * 通过修改生成的 Application.class 的路径到根加载器的加载路径下，那么该类将有根加载器加载
 */

public class ClassLoaderPathTest_1 {

  public static void main(String[] args) throws Exception {

    MyClassLoader loader1 = new MyClassLoader("loader1");
    loader1.setPath("/Users/monk/Desktop/");

    Class<?> aClass = loader1.loadClass("com.github.mgljava.basicstudy.Application");
    System.out.println(aClass);
    System.out.println(aClass.getClassLoader());

    System.out.println(ClassLoaderPathTest_1.class.hashCode());
    System.out.println(ClassLoaderPathTest.class.hashCode());
  }
}
