package com.github.mgljava.basicstudy.designpattern.newversion.template_method;

public abstract class TemplateMethod {

  final void doLogic() {
    System.out.println("TemplateMethod -- 开始");
    this.begin();
    System.out.println("TemplateMethod -- 中间");
    this.end();
    System.out.println("TemplateMethod -- 结束");
  }

  abstract void begin();

  abstract void end();
}
