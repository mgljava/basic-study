package com.github.mgljava.basicstudy.designpattern.newversion.mediator;

public class IraqCountry extends Country {

  public IraqCountry(UnitedNations unitedNations) {
    super(unitedNations);
  }

  // 声明
  public void declare(String message) {
    super.mediator.declare(message, this);
  }

  // 获得消息
  public void getMessage(String message) {
    System.out.println("Iraq 获得对方消息:" + message);
  }
}
