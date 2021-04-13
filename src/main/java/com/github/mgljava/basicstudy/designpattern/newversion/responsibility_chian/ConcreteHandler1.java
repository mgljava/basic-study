package com.github.mgljava.basicstudy.designpattern.newversion.responsibility_chian;

public class ConcreteHandler1 extends Handler {

  @Override
  void handleRequest(int request) {
    if (request >= 0 && request < 10) {
      System.out.printf("数字%s, 在0~10之间，ConcreteHandler1 处理请求", request);
      System.out.println();
    } else if (successor != null) {
      // 转移到下一位
      successor.handleRequest(request);
    }
  }
}
