package com.github.mgljava.basicstudy.jvm.classloader;

public class MyClassLoaderTest2 {

  public static void main(String[] args) throws Exception{
    MyClassLoader loader1 = new MyClassLoader("loader1");

    Class<?> clazz = loader1.loadClass("com.github.mgljava.basicstudy.jvm.classloader.MySample");
    System.out.println("class : " + clazz.hashCode());

    // 生成类的实例，就会实例化MySample对象，执行构造方法
    Object o = clazz.newInstance();
  }
}
