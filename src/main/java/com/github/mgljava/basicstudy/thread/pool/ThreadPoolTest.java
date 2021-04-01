package com.github.mgljava.basicstudy.thread.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

  static ThreadPoolExecutor executor = new ThreadPoolExecutor(0, 2, 20000L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2));

  public static void main(String[] args) {
    executor.submit(() -> System.out.println("Hello World!"));
    executor.submit(() -> System.out.println("Welcome"));
  }
}
