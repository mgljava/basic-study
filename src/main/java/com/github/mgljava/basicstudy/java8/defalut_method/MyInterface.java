package com.github.mgljava.basicstudy.java8.defalut_method;

public interface MyInterface {

  void sayHello();

  default void sayWelcome() {
    System.out.println("Welcome");
  }

  static void sayName(String name) {
    System.out.println("Name is : " + name);
  }

  default String getName(String name) {
    return "Name is : " + name;
  }
}
