package com.github.mgljava.basicstudy.thread;

public class DaemonThreadTest {

  public static void main(String[] args) {

    Thread thread = new Thread(() -> {
      for (;;){}
    });

    thread.setDaemon(true);
    thread.start();

    System.out.println("Main Thread is over;");

  }
}
