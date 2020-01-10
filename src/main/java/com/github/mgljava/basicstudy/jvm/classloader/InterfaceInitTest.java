package com.github.mgljava.basicstudy.jvm.classloader;

import java.util.Random;

/**
 * 如果引用的值是常量值，那么就不会加载接口，因为接口中定义的值时 public static final
 * 如果是类似于 Random 生成的值，那么就会加载接口
 */
public class InterfaceInitTest {

  public static void main(String[] args) {
    System.out.println(MyChild5.B);
    System.out.println(MyChild5.A);

  }
}

interface MyParent5 {

  int A = new Random().nextInt(3);
}

interface MyChild5 extends MyParent5 {

  int B = 5;
}
