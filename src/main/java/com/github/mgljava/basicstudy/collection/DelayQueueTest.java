package com.github.mgljava.basicstudy.collection;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {

  public static void main(String[] args) {
    DelayQueue<MyDelayed> queue = new DelayQueue<>();
    queue.add(new MyDelayed());
  }
}

class MyDelayed implements Delayed {

  @Override
  public long getDelay(TimeUnit unit) {
    return 0;
  }

  @Override
  public int compareTo(Delayed o) {
    return 0;
  }
}