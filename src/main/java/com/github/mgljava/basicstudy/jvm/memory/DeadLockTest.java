package com.github.mgljava.basicstudy.jvm.memory;

/**
 *
 * 通过jconsole或者jvisualvm来查看死锁的情况
 */

public class DeadLockTest {

  private static final Object object1 = new Object();
  private static final Object object2 = new Object();

  public static void main(String[] args) throws Exception {
    DeadLockTest deadLockTest = new DeadLockTest();
    new Thread(new MyThread()).start();
    deadLockTest.test2();
  }

  static class MyThread implements Runnable {
    @Override
    public void run() {
      test1();
    }
  }

  public static void test1()  {
    synchronized (object1) {
      System.out.println("test1 object1");
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (object2) {
        System.out.println("test1 object2");
      }
    }
  }

  public void test2() throws Exception {
    synchronized (object2) {
      System.out.println("test2 object2");
      Thread.sleep(2000);
      synchronized (object1) {
        System.out.println("test2 object1");
      }
    }
  }
}
