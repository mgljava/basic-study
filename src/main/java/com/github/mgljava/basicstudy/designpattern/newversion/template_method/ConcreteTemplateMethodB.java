package com.github.mgljava.basicstudy.designpattern.newversion.template_method;

public class ConcreteTemplateMethodB extends TemplateMethod {

  @Override
  void begin() {
    System.out.println("B 开始了");
  }

  @Override
  void end() {
    System.out.println("B 结束了");
  }
}
