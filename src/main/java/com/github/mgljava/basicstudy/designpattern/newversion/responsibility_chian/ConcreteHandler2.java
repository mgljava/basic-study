package com.github.mgljava.basicstudy.designpattern.newversion.responsibility_chian;

public class ConcreteHandler2 extends Handler {

  @Override
  void handleRequest(int request) {
    if (request >= 10 && request < 20) {
      System.out.printf("数字%s, 在10~20之间，ConcreteHandler2 处理请求", request);
      System.out.println();
    } else if (successor != null) {
      // 转移到下一位
      successor.handleRequest(request);
    }
  }
}
