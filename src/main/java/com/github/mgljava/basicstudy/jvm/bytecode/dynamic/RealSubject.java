package com.github.mgljava.basicstudy.jvm.bytecode.dynamic;


public class RealSubject implements Subject {

  @Override
  public void request() {
    System.out.println("From RealSubject");
  }
}
