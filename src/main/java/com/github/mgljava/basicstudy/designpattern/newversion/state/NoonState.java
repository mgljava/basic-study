package com.github.mgljava.basicstudy.designpattern.newversion.state;

public class NoonState implements State {

  @Override
  public void writeProgram(Work w) {
    if (w.getHour() < 13D) {
      System.out.printf("当前时间:%s点饿了，午饭，犯困，午休", w.getHour());
    } else {
      w.setCurrentState(new AfternoonState());
      w.writeProgram();
    }
  }
}
