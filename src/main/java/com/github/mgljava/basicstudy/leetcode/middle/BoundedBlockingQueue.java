package com.github.mgljava.basicstudy.leetcode.middle;

public class BoundedBlockingQueue {

  public static void main(String[] args) throws Exception {
    BoundedBlockingQueue boundedBlockingQueue = new BoundedBlockingQueue(3);
    boundedBlockingQueue.enqueue(2);
    boundedBlockingQueue.enqueue(3);
    boundedBlockingQueue.enqueue(4);
    System.out.println("size: " + boundedBlockingQueue.size());
    System.out.println(boundedBlockingQueue.dequeue());
    System.out.println(boundedBlockingQueue.dequeue());
    System.out.println(boundedBlockingQueue.dequeue());
  }

  int[] item;
  int count;
  int takeIndex;
  int putIndex;

  public BoundedBlockingQueue(int capacity) {
    item = new int[capacity];
  }

  public void enqueue(int element) throws InterruptedException {
    int[] items = this.item;
    items[putIndex] = element;
    if (++putIndex == items.length) {
      putIndex = 0;
    }
    count++;
  }

  public int dequeue() throws InterruptedException {
    int[] items = this.item;
    int ans = items[takeIndex];
    items[takeIndex] = 0;
    if (++takeIndex == items.length) {
      takeIndex = 0;
    }
    count--;
    return ans;
  }

  public int size() {
    return count;
  }
}
