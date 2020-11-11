package com.github.mgljava.basicstudy.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

  private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> System.out.println("welcome"));

  public static void main(String[] args) {
    new Thread(() -> {
      System.out.println("hello1");
      try {
        cyclicBarrier.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (BrokenBarrierException e) {
        e.printStackTrace();
      }
    }).start();
    System.out.println("main before");
    new Thread(() -> {
      System.out.println("hello2");
      try {
        cyclicBarrier.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (BrokenBarrierException e) {
        e.printStackTrace();
      }
    }).start();

    // 后续可以循环利用
    new Thread(() -> {
      System.out.println("hello3");
      try {
        cyclicBarrier.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (BrokenBarrierException e) {
        e.printStackTrace();
      }
    }).start();
    new Thread(() -> {
      System.out.println("hello4");
      try {
        cyclicBarrier.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (BrokenBarrierException e) {
        e.printStackTrace();
      }
    }).start();
  }
}
