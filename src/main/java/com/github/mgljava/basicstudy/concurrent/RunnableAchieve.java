package com.github.mgljava.basicstudy.concurrent;

/**
 * 实现Runnable接口来实现线程
 */
public class RunnableAchieve implements Runnable {

  private int size;

  public RunnableAchieve(int size) {
    this.size = size;
  }

  @Override
  public void run() {
    System.out.println(size);
  }

  public static void main(String[] args) {
    RunnableAchieve runnableAchieve = new RunnableAchieve(123);
    new Thread(runnableAchieve).start();
  }
}
