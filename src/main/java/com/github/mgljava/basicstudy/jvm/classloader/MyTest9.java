package com.github.mgljava.basicstudy.jvm.classloader;

import java.net.URL;
import java.util.Enumeration;

class MyParent9 {

  static int a = 3;

  {
    System.out.println("MyParent9");
  }

  static {
    System.out.println("MyParent9 static block");
  }
}

class MyChild9 extends MyParent9 {

  static int b = 3;

  {
    System.out.println("MyChild9");
  }

  static {
    System.out.println("MyChild9 static block");
  }
}

public class MyTest9 {

  {
    System.out.println("MyTest9");
  }

  static {
    System.out.println("MyTest9 static block");
  }

  public static void main(String[] args) throws Exception {
    // System.out.println(new MyChild9());
    ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
    String resource = "java/lang/String.class";
    Enumeration<URL> resources = contextClassLoader.getResources(resource);
    while (resources.hasMoreElements()) {
      URL url = resources.nextElement();
      System.out.println(url);
    }
  }
}
