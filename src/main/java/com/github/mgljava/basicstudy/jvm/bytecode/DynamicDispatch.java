package com.github.mgljava.basicstudy.jvm.bytecode;

/**
 * 方法的动态分派
 * 方法的动态分派涉及到一个重要的概念：方法接收者（该方法到底由那个对象来接收的）
 *
 * invokevirtual字节码指令的多态查找流程
 *
 *  比较方法重写和方法重载，有一个结论：
 *  方法重写是在编译期的行为
 *  方法重载是在运行期的行为
 */

public class DynamicDispatch {

  public static void main(String[] args) {

    Fruit apple = new Apple();
    Fruit orange = new Orange();

    apple.test();
    orange.test();

    apple = new Orange();
    apple.test();
  }
}

class Fruit {

  public void test() {
    System.out.println("Fruit");
  }
}

class Apple extends Fruit {

  @Override
  public void test() {
    System.out.println("Apple");
  }
}

class Orange extends Fruit {

  @Override
  public void test() {
    System.out.println("Orange");
  }
}