package com.github.mgljava.basicstudy.jvm.bytecode.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

  public static void main(String[] args) {

    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

    RealSubject realSubject = new RealSubject();
    InvocationHandler invocationHandler = new DynamicSubject(realSubject);

    Subject subject = (Subject) Proxy.
        newProxyInstance(Client.class.getClassLoader(), realSubject.getClass().getInterfaces(), invocationHandler);
    subject.request();
    System.out.println("---------------");
    System.out.println(subject.toString());
    System.out.println("---------------");
    System.out.println(subject.getClass());
    System.out.println(subject.getClass().getSuperclass());
  }
}
