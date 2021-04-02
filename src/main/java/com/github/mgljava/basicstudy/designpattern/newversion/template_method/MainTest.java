package com.github.mgljava.basicstudy.designpattern.newversion.template_method;

public class MainTest {

  public static void main(String[] args) {
    TemplateMethod templateMethodA = new ConcreteTemplateMethodA();
    templateMethodA.doLogic();

    System.out.println("-------------------");

    TemplateMethod templateMethodB = new ConcreteTemplateMethodB();
    templateMethodB.doLogic();
  }
}
