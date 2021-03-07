package com.github.mgljava.basicstudy.anno;

public class Test {

  public static void main(String[] args) throws ClassNotFoundException {
    Class<?> aClass = Class.forName("com.github.mgljava.basicstudy.anno.MyAnnotation");
    System.out.println(aClass.getAnnotations()[0]);
    Package aPackage = aClass.getPackage();
    System.out.println(aPackage.getName());
  }
}
