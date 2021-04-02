package com.github.mgljava.basicstudy.designpattern.newversion.template_method;

public class ConcreteTemplateMethodA extends TemplateMethod {

  @Override
  void begin() {
    System.out.println("A 开始了");
  }

  @Override
  void end() {
    System.out.println("A 结束了");
  }
}
