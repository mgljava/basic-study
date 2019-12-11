package com.github.mgljava.basicstudy.thread;

public class VolatileTest extends Thread {

  private int data = 0;

  public static void main(String[] args) {
    final VolatileTest obj = new VolatileTest();
    for (int i = 0; i < 2000; i++) {
      new Thread(() -> obj.data++).start();
    }
    System.out.println(obj.data);
  }
}
