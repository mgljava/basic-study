package com.github.mgljava.basicstudy.java8.defalut_method;

public interface D {
  default void hello() {
    System.out.println("hello from A");
  }
}
