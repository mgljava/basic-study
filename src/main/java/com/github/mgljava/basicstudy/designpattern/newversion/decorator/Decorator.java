package com.github.mgljava.basicstudy.designpattern.newversion.decorator;

/**
 * 装饰抽象类，从外类来扩展 Component 的功能
 */
public abstract class Decorator extends Component {

  protected Component component;

  public void setComponent(Component component) {
    this.component = component;
  }

  @Override
  void operation() {
    if (null != component) {
      component.operation();
    }
  }
}
