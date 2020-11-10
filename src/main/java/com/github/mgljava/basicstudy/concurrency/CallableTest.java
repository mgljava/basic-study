package com.github.mgljava.basicstudy.concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CallableTest {

  volatile static boolean flag = true;

  public static void main(String[] args) throws Exception {
    /*Callable<String> callable = () -> {
      System.out.println("zhangsan");
      return "hello";
    };
    ExecutorService executorService = Executors.newCachedThreadPool();
    Future<String> submit = executorService.submit(callable);
    System.out.println(submit.get());
    executorService.shutdown();*/

    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
    scheduledExecutorService.schedule(() -> System.out.println("Hello"), 2, TimeUnit.SECONDS);
    scheduledExecutorService.shutdown();

    ScheduledExecutorService scheduledExecutorService1 = Executors.newScheduledThreadPool(2);
    scheduledExecutorService1.scheduleAtFixedRate(() -> System.out.println("hello world"), 1, 2, TimeUnit.SECONDS);
    scheduledExecutorService1.scheduleAtFixedRate(() -> {
      System.out.println(LocalDateTime.now());
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }, 1, 2, TimeUnit.SECONDS);

    /*ExecutorService executorService = Executors.newFixedThreadPool(3);
    for (int i = 0; i < 10; i++) {
      final AtomicInteger atomicInteger = new AtomicInteger(i);
      executorService.execute(() -> {
        if (atomicInteger.get() % 3 == 0) {
          throw new RuntimeException("error");
        } else {
          System.out.println("normal" + atomicInteger.get());
        }
      });
    }
    executorService.shutdown();*/
    new Thread(() -> {
      while (flag) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(LocalDateTime.now());
      }
    }).start();

    Thread.sleep(3000);
    new Thread(() -> {
      flag = false;
    }).start();
  }
}
