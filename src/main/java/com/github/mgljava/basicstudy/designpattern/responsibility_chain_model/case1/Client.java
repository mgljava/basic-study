package com.github.mgljava.basicstudy.designpattern.responsibility_chain_model.case1;

public class Client {

  public static void main(String[] args) {

    Handler handler1 = new ConcreteHandler();
    Handler handler2 = new ConcreteHandler();

    handler1.setSuccessor(handler2);
    handler1.handleRequest();
  }
}
