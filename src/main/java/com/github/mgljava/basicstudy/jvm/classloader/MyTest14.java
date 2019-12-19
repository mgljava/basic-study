package com.github.mgljava.basicstudy.jvm.classloader;

import java.net.URL;
import java.util.Enumeration;

// 通过给的的字节码加载类信息
public class MyTest14 {

  public static void main(String[] args) throws Exception {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    String resource = "com/github/mgljava/basicstudy/jvm/classloader/MyTest13.class";

    // 获取文件在文件系统中的全路径
    Enumeration<URL> resources = classLoader.getResources(resource);
    while (resources.hasMoreElements()) {
      System.out.println(resources.nextElement());
    }
    System.out.println("-----------------------");
    Class<?> clazz = MyTest14.class;
    System.out.println(clazz.getClassLoader());
    System.out.println("-----------------------");
    Class<?> stringClass = String.class;
    System.out.println(stringClass.getClassLoader());
  }
}
