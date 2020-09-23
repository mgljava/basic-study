package com.github.mgljava.basicstudy.leetcode.easy;

import java.util.concurrent.atomic.AtomicInteger;

// 按序打印
public class PrintInOrder1114 {

  private final AtomicInteger firstJob = new AtomicInteger(0);
  private final AtomicInteger secondJob = new AtomicInteger(0);

  public void first(Runnable printFirst) throws InterruptedException {

    // printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run();
    firstJob.incrementAndGet();
  }

  public void second(Runnable printSecond) throws InterruptedException {
    while (firstJob.get() != 1) {
    }
    // printSecond.run() outputs "second". Do not change or remove this line.

    printSecond.run();
    secondJob.incrementAndGet();
  }

  public void third(Runnable printThird) throws InterruptedException {
    while (secondJob.get() != 1) {
    }
    // printThird.run() outputs "third". Do not change or remove this line.
    printThird.run();
  }
}
