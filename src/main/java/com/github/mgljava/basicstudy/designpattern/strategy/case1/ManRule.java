package com.github.mgljava.basicstudy.designpattern.strategy.case1;

public class ManRule implements AbstractRule {

  @Override
  public void sayNumber(String number) {
    System.out.println("Man should Say Number is " + number);
  }
}
