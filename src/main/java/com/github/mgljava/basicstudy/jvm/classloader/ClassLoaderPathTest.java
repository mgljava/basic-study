package com.github.mgljava.basicstudy.jvm.classloader;

public class ClassLoaderPathTest {

  public static void main(String[] args) {
    // 根加载器加载路径
    System.out.println(System.getProperty("sun.boot.class.path"));
    System.out.println("-----------------------");
    // 扩展类加载器加载路径
    System.out.println(System.getProperty("java.ext.dirs"));
    System.out.println("-----------------------");
    // 系统/应用类加载器加载路径
    System.out.println(System.getProperty("java.class.path"));

  }
}
