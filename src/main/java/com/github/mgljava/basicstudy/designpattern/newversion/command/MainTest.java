package com.github.mgljava.basicstudy.designpattern.newversion.command;

public class MainTest {

  public static void main(String[] args) {
    Receiver receiver = new Receiver();
    ConcreteCommand concreteCommand = new ConcreteCommand(receiver);
    Invoker invoker = new Invoker();

    invoker.setCommand(concreteCommand);
    invoker.executeCommand();
  }
}
