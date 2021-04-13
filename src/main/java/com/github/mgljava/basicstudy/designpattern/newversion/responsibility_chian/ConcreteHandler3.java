package com.github.mgljava.basicstudy.designpattern.newversion.responsibility_chian;

public class ConcreteHandler3 extends Handler {

  @Override
  void handleRequest(int request) {
    if (request >= 20 && request < 30) {
      System.out.printf("数字%s, 在20~30之间，ConcreteHandler3 处理请求", request);
      System.out.println();
    } else if (successor != null) {
      // 转移到下一位
      successor.handleRequest(request);
    }
  }
}
