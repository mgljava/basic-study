package com.github.mgljava.basicstudy.thread;

public class ThreadTest {

  int num = 0;

  public static void main(String[] args) throws Exception {
    ThreadTest threadTest = new ThreadTest();
    threadTest.t2();
    threadTest.t1();
    threadTest.t2();

  }

  void t1() throws InterruptedException {
    num++;
  }

  void t2() {
    System.out.println(num);
  }
}
