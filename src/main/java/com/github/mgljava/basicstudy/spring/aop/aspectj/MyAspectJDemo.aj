package com.github.mgljava.basicstudy.spring.aop.aspectj;

public aspect MyAspectJDemo {

  /**
   * 定义切点,日志记录切点
   */
  pointcut recordLog():call(* HelloWorld.sayHello(..));

  /**
   * 定义切点,权限验证(实际开发中日志和权限一般会放在不同的切面中,这里仅为方便演示)
   */
  pointcut authCheck():call(* HelloWorld.sayHello(..));

  /**
   * 定义前置通知!
   */
  before():authCheck(){
    System.out.println("sayHello方法执行前验证权限");
  }

  /**
   * 定义后置通知
   */
  after():recordLog(){
    System.out.println("sayHello方法执行后记录日志");
  }
}
