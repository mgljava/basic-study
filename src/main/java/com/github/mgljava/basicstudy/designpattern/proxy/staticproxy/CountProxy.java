package com.github.mgljava.basicstudy.designpattern.proxy.staticproxy;

import lombok.AllArgsConstructor;

/**
 * 代理类（增强CountImpl实现类）
 */
@AllArgsConstructor
public class CountProxy implements Count {

  private CountImpl countImpl;

  @Override
  public void queryCount() {
    System.out.println("事务处理之前");
    // 调用委托类的方法;
    countImpl.queryCount();
    System.out.println("事务处理之后");
  }

  @Override
  public void updateCount() {
    System.out.println("事务处理之前");
    // 调用委托类的方法;
    countImpl.updateCount();
    System.out.println("事务处理之后");
  }
}
