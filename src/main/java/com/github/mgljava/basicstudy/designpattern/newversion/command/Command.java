package com.github.mgljava.basicstudy.designpattern.newversion.command;

public abstract class Command {

  protected Receiver receiver;

  public Command(Receiver receiver) {
    this.receiver = receiver;
  }

  // 执行具体的命令
  abstract void execute();
}
