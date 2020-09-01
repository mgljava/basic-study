package com.github.mgljava.basicstudy.concurrency;

public class DeadLockTest {

  public static void main(String[] args) {
    Thread t1 = new Thread(new DeadLock(true));//建立一个线程
    Thread t2 = new Thread(new DeadLock(false));//建立另一个线程
    t1.setName("thread-dufy-1");
    t2.setName("thread-dufy-2");
    t1.start();//启动一个线程
    t2.start();//启动另一个线程
  }
}

class DeadLock implements Runnable {

  public boolean flag;

  DeadLock(boolean flag) {
    this.flag = flag;
  }

  @Override
  public void run() {
    if (flag) {
      while (true) {
        synchronized (Demo.o1) {
          System.out.println("o1 " + Thread.currentThread().getName());
          synchronized (Demo.o2) {
            System.out.println("o2 " + Thread.currentThread().getName());
          }
        }
      }
    } else {
      while (true) {
        synchronized (Demo.o2) {
          System.out.println("o2 " + Thread.currentThread().getName());
          synchronized (Demo.o1) {
            System.out.println("o1 " + Thread.currentThread().getName());
          }
        }
      }
    }
  }
}

class Demo {

  static Object o1 = new Object();
  static Object o2 = new Object();
}
