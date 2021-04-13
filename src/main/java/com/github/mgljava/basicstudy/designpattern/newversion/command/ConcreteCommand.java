package com.github.mgljava.basicstudy.designpattern.newversion.command;

public class ConcreteCommand extends Command {

  public ConcreteCommand(Receiver receiver) {
    super(receiver);
  }

  @Override
  void execute() {
    receiver.action();
  }
}
