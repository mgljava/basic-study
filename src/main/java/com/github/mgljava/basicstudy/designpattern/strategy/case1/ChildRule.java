package com.github.mgljava.basicstudy.designpattern.strategy.case1;

public class ChildRule implements AbstractRule {

  @Override
  public void sayNumber(String number) {
    System.out.println("Child should Say number is " + number);
  }
}
