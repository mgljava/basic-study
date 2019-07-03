package com.github.mgljava.basicstudy.spring.aop.aspectj;

public class HelloWorld {

  public void sayHello() {
    System.out.println("hello world !");
  }

  public static void main(String args[]) {
    HelloWorld helloWord = new HelloWorld();
    helloWord.sayHello();
  }
}
