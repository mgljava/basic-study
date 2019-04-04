package com.github.mgljava.basicstudy.designpattern.observer;

public class LambdaObserverTest {

  public static void main(String[] args) {

    Subject subject = new Feed();
    subject.registerObserver(tweet -> {
      if (tweet != null && tweet.contains("money")) {
        System.out.println("Breaking news in NY! " + tweet);
      }
    });

    subject.registerObserver(tweet -> {
      if (tweet != null && tweet.contains("queen")) {
        System.out.println("Yet another news in London... " + tweet);
      }
    });

    subject.notifyObservers("queen is hello world!");
  }
}
