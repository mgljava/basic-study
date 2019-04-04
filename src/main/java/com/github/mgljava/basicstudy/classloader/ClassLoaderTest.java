package com.github.mgljava.basicstudy.classloader;

public class ClassLoaderTest {

  public static void main(String[] args) {

    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    System.out.println("current loader : " + classLoader);
    System.out.println("parent loader : " + classLoader.getParent());
    System.out.println("parent parent loader : " + classLoader.getParent().getParent());

  }
}
