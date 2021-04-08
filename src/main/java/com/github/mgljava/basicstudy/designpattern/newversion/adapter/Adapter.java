package com.github.mgljava.basicstudy.designpattern.newversion.adapter;

public class Adapter extends Target {

  private final Adaptee adaptee = new Adaptee();

  @Override
  public void request() {
    adaptee.specificRequest();
  }
}
