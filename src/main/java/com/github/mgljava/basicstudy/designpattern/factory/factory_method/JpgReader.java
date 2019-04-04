package com.github.mgljava.basicstudy.designpattern.factory.factory_method;

public class JpgReader implements Reader {

  @Override
  public void read() {
    System.out.println("read jpg");
  }
}
