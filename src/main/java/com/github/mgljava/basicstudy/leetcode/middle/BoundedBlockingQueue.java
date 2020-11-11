package com.github.mgljava.basicstudy.leetcode.middle;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {

  int[] items;
  int count;
  int putIndex;
  int takeIndex;
  ReentrantLock lock = new ReentrantLock();
  Condition takeLock = lock.newCondition();
  Condition putLock = lock.newCondition();

  public BoundedBlockingQueue(int capacity) {
    items = new int[capacity];
  }

  public void enqueue(int element) throws InterruptedException {
    lock.lock();
    try {
      while (count == items.length) {
        putLock.await();
      }
      items[putIndex++] = element;
      count++;
      takeLock.signal();
    } finally {
      lock.unlock();
    }
  }

  public int dequeue() throws InterruptedException {
    lock.lock();
    try {
      while (count == 0) {
        takeLock.await();
      }
      int item = items[takeIndex++];
      putLock.signal();
      count--;
      return item;
    } finally {
      lock.unlock();
    }
  }

  public int size() {
    return count;
  }

  public static void main(String[] args) throws Exception {
    BoundedBlockingQueue queue = new BoundedBlockingQueue(2);   // 使用capacity = 2初始化队列。

    queue.enqueue(1);   // 生产者线程将1插入队列。
    System.out.println(queue.dequeue()); // 消费者线程调用dequeue并返回1。
    queue.dequeue();    // 由于队列为空，消费者线程被阻塞。
    queue.enqueue(0);   // 生产者线程将0插入队列。消费者线程被解除阻塞同时将0弹出队列并返回。
    queue.enqueue(2);   // 生产者线程将2插入队列。
    queue.enqueue(3);   // 生产者线程将3插入队列。
    queue.enqueue(4);   // 生产者线程由于队列长度已达到上限2而被阻塞。
    queue.dequeue();    // 消费者线程将2从队列弹出并返回。生产者线程解除阻塞同时将4插入队列。
    System.out.println(queue.size());       // 队列中还有2个元素。size()方法在每组测试用例最后调用。
  }
}
