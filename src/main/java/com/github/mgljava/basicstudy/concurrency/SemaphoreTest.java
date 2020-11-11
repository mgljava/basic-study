package com.github.mgljava.basicstudy.concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

  public static void main(String[] args) {

    // 同一时刻只允许一个线程获取到锁；控制同时访问的线程个数
    Semaphore semaphore = new Semaphore(2);

    for (int i = 0; i < 10; i++) {
      new Thread(() -> {
        try {
          semaphore.acquire();
          System.out.println(semaphore.getQueueLength());
          System.out.println(LocalDateTime.now());
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          semaphore.release();
        }
      }).start();
    }
  }
}
