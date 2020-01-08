package com.github.mgljava.basicstudy.jvm.classloader;

import java.sql.Connection;

/**
 * 线程上下文类加载器
 */
public class ThreadClassLoaderTest {

  public static void main(String[] args) {
    System.out.println(Thread.currentThread().getContextClassLoader());
    System.out.println(Thread.class.getClassLoader());
    System.out.println(Connection.class.getClassLoader());
  }
}
