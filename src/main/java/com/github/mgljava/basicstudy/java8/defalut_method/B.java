package com.github.mgljava.basicstudy.java8.defalut_method;

public interface B extends A{
  default void hello() {
    System.out.println("hello from B");
  }
}
