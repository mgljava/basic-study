package com.github.mgljava.basicstudy.designpattern.newversion.responsibility_chian;

import java.util.Arrays;

public class MainTest {

  public static void main(String[] args) {
    ConcreteHandler1 concreteHandler1 = new ConcreteHandler1();
    ConcreteHandler2 concreteHandler2 = new ConcreteHandler2();
    ConcreteHandler3 concreteHandler3 = new ConcreteHandler3();

    concreteHandler1.setSuccessor(concreteHandler2);
    concreteHandler2.setSuccessor(concreteHandler3);

    int[] requests = new int[] {12, 9, 15, 80, 23};

    Arrays.stream(requests).forEach(concreteHandler1::handleRequest);
  }
}
