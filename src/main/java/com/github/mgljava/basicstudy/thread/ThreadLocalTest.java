package com.github.mgljava.basicstudy.thread;


public class ThreadLocalTest {

  static ThreadLocal<String> threadLocal = new ThreadLocal<>();

  static void print(String str) {
    System.out.println(str + " : " + threadLocal.get());
    threadLocal.remove();
  }

  public static void main(String[] args) {

    Thread one = new Thread(() -> {
      threadLocal.set("one local var.");
      print("one");
      System.out.println("one : " + threadLocal.get());
    });

    Thread two = new Thread(() -> {
      threadLocal.set("two local var.");
      print("two");
      System.out.println("two : " + threadLocal.get());
    });

    one.start();
    two.start();
  }
}
