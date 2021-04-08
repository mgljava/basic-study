package com.github.mgljava.basicstudy.designpattern.newversion.state;

public class RestState implements State {

  @Override
  public void writeProgram(Work w) {
    System.out.println("休息了");
  }
}
