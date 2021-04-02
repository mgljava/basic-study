package com.github.mgljava.basicstudy.designpattern.newversion.decorator;

/**
 * 定义了一个具体的对象，给对象添加职责
 */
public class ConcreteComponent extends Component {

  @Override
  public void operation() {
    System.out.println("具体对象的操作");
  }
}
