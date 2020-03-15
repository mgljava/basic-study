package com.github.mgljava.basicstudy.concurrent;

/**
 * 通过继承Thread类来实现线程
 */
public class ThreadAchieve extends Thread {

  private int size;

  public ThreadAchieve(int size) {
    this.size = size;
  }

  @Override
  public void run() {
    System.out.println(size);
  }

  public static void main(String[] args) {
    new ThreadAchieve(123).start();
  }
}
