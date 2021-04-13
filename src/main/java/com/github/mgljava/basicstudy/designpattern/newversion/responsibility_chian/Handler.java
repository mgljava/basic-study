package com.github.mgljava.basicstudy.designpattern.newversion.responsibility_chian;

/**
 * 定义处理请求的接口
 */
public abstract class Handler {

  protected Handler successor;

  public void setSuccessor(Handler successor) {
    this.successor = successor;
  }

  abstract void handleRequest(int request);
}
