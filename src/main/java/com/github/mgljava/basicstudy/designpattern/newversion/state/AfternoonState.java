package com.github.mgljava.basicstudy.designpattern.newversion.state;

public class AfternoonState implements State {

  @Override
  public void writeProgram(Work w) {
    if(w.getHour() < 17D) {
      System.out.printf("当前时间:%s,点 下午状态还不错，继续努力", w.getHour());
    } else {
      w.setCurrentState(new RestState());
      w.writeProgram();
    }
  }
}
