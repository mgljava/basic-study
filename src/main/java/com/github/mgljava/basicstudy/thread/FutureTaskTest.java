package com.github.mgljava.basicstudy.thread;

import java.util.concurrent.FutureTask;

public class FutureTaskTest {

  public static void main(String[] args) throws Exception {

    FutureTask futureTask = new FutureTask<>(() -> "welcome");
    new Thread(futureTask).start();
    String result = (String) futureTask.get();
    System.out.println(result);
  }
}
