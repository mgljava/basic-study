package com.github.mgljava.basicstudy.collection;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {

  public static void main(String[] args) throws InterruptedException {
    final DelayQueue<MyDelayed> delayQueue = new DelayQueue<>();
    new Thread(() -> {
      delayQueue.offer(new MyDelayed("task1", 10000));
      delayQueue.offer(new MyDelayed("task2", 3900));
      delayQueue.offer(new MyDelayed("task3", 1900));
      delayQueue.offer(new MyDelayed("task4", 5900));
      delayQueue.offer(new MyDelayed("task5", 6900));
      delayQueue.offer(new MyDelayed("task6", 7900));
      delayQueue.offer(new MyDelayed("task7", 4900));
    }).start();

    while (true) {
      Delayed take = delayQueue.take();
      System.out.println(take);
    }
  }
}

class MyDelayed implements Delayed {

  private final String name;
  private final long start = System.currentTimeMillis();
  private final long time;

  public MyDelayed(String name, long time) {
    this.name = name;
    this.time = time;
  }

  @Override
  public long getDelay(TimeUnit unit) {
    return unit.convert((start + time) - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
  }

  @Override
  public int compareTo(Delayed o) {
    MyDelayed myDelayed = (MyDelayed) o;
    return (int) (this.getDelay(TimeUnit.MILLISECONDS) - myDelayed.getDelay(TimeUnit.MILLISECONDS));
  }

  @Override
  public String toString() {
    return "MyDelayedTask{" +
        "name='" + name + '\'' +
        ", time=" + time +
        '}';
  }
}