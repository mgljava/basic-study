package com.github.mgljava.basicstudy.designpattern.newversion.mediator;

public class USACountry extends Country {

  public USACountry(UnitedNations unitedNations) {
    super(unitedNations);
  }

  // 声明
  public void declare(String message) {
    super.mediator.declare(message, this);
  }

  // 获得消息
  public void getMessage(String message) {
    System.out.println("USA 获得对方消息:" + message);
  }
}
