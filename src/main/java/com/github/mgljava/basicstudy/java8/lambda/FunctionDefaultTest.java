package com.github.mgljava.basicstudy.java8.lambda;

@FunctionalInterface
public interface FunctionDefaultTest {

  String sayHello(String name);

  String toString();

  default void sayWorld() {

  }
}
