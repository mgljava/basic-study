package com.github.mgljava.basicstudy.designpattern.proxy.dynamic;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 使用cglib动态代理
 */
public class BookFacadeCglibProxy implements MethodInterceptor {

  private Object target;

  /**
   * 创建代理对象
   */
  public Object getInstance(Object object) {
    this.target = object;
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(this.target.getClass());
    // 回调方法
    enhancer.setCallback(this);
    // 创建代理对象
    return enhancer.create();
  }

  @Override
  public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy)
      throws Throwable {
    System.out.println("Cglib 动态代理开始");
    proxy.invokeSuper(object, args);
    System.out.println("Cglib 动态代理结束");
    return null;
  }
}
