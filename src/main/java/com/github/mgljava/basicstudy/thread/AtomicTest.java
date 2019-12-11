package com.github.mgljava.basicstudy.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

  private int num = 0;
  private AtomicInteger atomicInteger = new AtomicInteger(0);

  public void get() {
    this.num ++;
  }

  public static void main(String[] args) {
    AtomicTest atomicTest = new AtomicTest();
    for (int i = 0; i < 1000; i++) {
      new Thread(atomicTest::get).start();
    }
    System.out.println(atomicTest.num);
    System.out.println("------------------");
    for (int i = 0; i < 10; i++) {
      new Thread(() -> atomicTest.atomicInteger.incrementAndGet()).start();
    }
    System.out.println(atomicTest.atomicInteger.get());
  }
}
