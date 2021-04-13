package com.github.mgljava.basicstudy.designpattern.newversion.command;

// 负责接收命令并交由具体的执行者去执行
public class Invoker {

  private Command command;

  public void setCommand(Command command) {
    this.command = command;
  }

  public void executeCommand() {
    this.command.execute();
  }
}
