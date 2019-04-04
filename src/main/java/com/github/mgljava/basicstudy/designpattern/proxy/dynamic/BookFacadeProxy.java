package com.github.mgljava.basicstudy.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookFacadeProxy implements InvocationHandler {

  private Object target;

  /**
   * 绑定委托对象并返回一个代理类
   */
  public Object bind(Object object) {
    this.target = object;
    //取得代理对象
    return Proxy
        .newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
            this); //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)
  }

  /**
   * 调用方法
   */
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Object result;
    System.out.println("事务开始...");
    result = method.invoke(target, args);
    System.out.println("事务结束...");
    return result;
  }
}
