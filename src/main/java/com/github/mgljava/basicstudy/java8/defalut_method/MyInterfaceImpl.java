package com.github.mgljava.basicstudy.java8.defalut_method;

/**
 * 如果父类是默认方法 子类不用实现
 */
public class MyInterfaceImpl implements MyInterface {

  @Override
  public void sayHello() {
    System.out.println("Hello");
  }

  public void myMenthod() {
    System.out.println("method invoked!");
  }
}
