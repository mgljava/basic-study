package com.github.mgljava.basicstudy.designpattern.responsibility_chain_model.case1;

public class ConcreteHandler extends Handler {

  @Override
  public void handleRequest() {
    if (getSuccessor() != null) {
      System.out.println("放过请求");
      getSuccessor().handleRequest();
    } else {
      System.out.println("处理请求");
    }
  }
}
