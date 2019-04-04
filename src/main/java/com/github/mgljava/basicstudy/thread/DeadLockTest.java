package com.github.mgljava.basicstudy.thread;

// Don't Use this class
public class DeadLockTest {

  private static final Object resourceA = new Object();
  private static final Object resourceB = new Object();

  public static void main(String[] args) throws InterruptedException {

    Thread threadA = new Thread(() -> {
      synchronized (resourceA) {
        System.out.println("ThreadA get lock A!");
        synchronized (resourceB) {
          System.out.println("ThreadA get lock B!");
          System.out.println("ThreadA release lock A!");
          try {
            resourceA.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });

    Thread threadB = new Thread(() -> {
      try {
        Thread.sleep(1000);

        synchronized (resourceA) {
          System.out.println("ThreadB get lock A!");
          System.out.println("ThreadB try get lock B!");
          synchronized (resourceB) {
            System.out.println("ThreadB get lock B!");
            System.out.println("ThreadB release lock A!");
            try {
              resourceA.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    threadA.start();
    threadB.start();

    threadA.join();
    threadB.join();

    System.out.println("main over!");
  }
}
