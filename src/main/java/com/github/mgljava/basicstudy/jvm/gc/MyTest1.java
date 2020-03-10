package com.github.mgljava.basicstudy.jvm.gc;

/*
  通过设置JVM的参数来观察垃圾收集的输出内容
 */
public class MyTest1 {

  public static void main(String[] args) {
    int size = 1024 * 1024;

    byte[] myAlloc1 = new byte[2 * size];
    byte[] myAlloc2 = new byte[3 * size];
    byte[] myAlloc3 = new byte[3 * size];
    byte[] myAlloc4 = new byte[3 * size];
    System.out.println("Hello World!");
  }
}
