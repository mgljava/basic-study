package com.github.mgljava.basicstudy.designpattern.factory.factory_method;

public class PngReader implements Reader {

  @Override
  public void read() {
    System.out.println("read png");
  }
}
