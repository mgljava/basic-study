package com.github.mgljava.basicstudy.thread;

/**
 * 多线程交替打印 Foo Bar
 */
public class Alternate extends Thread {

  private int n;
  private boolean flag = true;

  public Alternate(int n) {
    this.n = n;
  }

  public void foo() {

    while (flag) {
      System.out.println("foo");
      flag = false;
    }
  }

  public void bar() {

    while (!flag) {
      System.out.println("bar");
      flag = true;
    }
  }

  @Override
  public void run() {
    for (int i = 0; i < n; i++) {
      foo();
      bar();
    }
  }

  public static void main(String[] args) {
    Alternate alternate = new Alternate(10);
    alternate.start();
  }
}
