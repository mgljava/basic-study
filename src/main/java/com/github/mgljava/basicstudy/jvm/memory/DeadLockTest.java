package com.github.mgljava.basicstudy.jvm.memory;

/**
 * 通过jconsole或者jvisualvm来查看死锁的情况
 */

public class DeadLockTest {

  private static final Object object1 = new Object();
  private static final Object object2 = new Object();

  public static void main(String[] args) {
    new Thread(DeadLockTest::test1, "Thread-A").start();
    new Thread(DeadLockTest::test2, "Thread-B").start();
  }

  public static void test1() {
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

  public static void test2() {
    synchronized (object2) {
      System.out.println("test2 object2");
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (object1) {
        System.out.println("test2 object1");
      }
    }
  }
}
