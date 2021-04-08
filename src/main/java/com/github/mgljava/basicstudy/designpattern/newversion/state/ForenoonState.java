package com.github.mgljava.basicstudy.designpattern.newversion.state;

public class ForenoonState implements State {

  @Override
  public void writeProgram(Work w) {
    if (w.getHour() < 12D) {
      System.out.printf("当前时间:%s点 上午工作，精神百倍", w.getHour());
    } else {
      w.setCurrentState(new NoonState());
      w.writeProgram();
    }
  }
}
