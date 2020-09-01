package com.github.mgljava.basicstudy.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

  public static void main(String[] args) throws InterruptedException {
    CountDownLatch countDownLatch = new CountDownLatch(5);
    for (int i = 0; i < 5; i++) {
      new Thread(new ReadNum(i, countDownLatch)).start();
    }
    countDownLatch.await();
    System.out.println("main 线程执行结束");
  }

  static class ReadNum implements Runnable {

    private final int id;
    private final CountDownLatch latch;

    ReadNum(int id, CountDownLatch latch) {
      this.id = id;
      this.latch = latch;
    }

    @Override
    public void run() {
      synchronized (this) {
        System.out.println("id:" + id);
        latch.countDown();
        System.out.println("线程组任务" + id + "结束，其他任务继续");
      }
    }
  }
}
