package com.github.mgljava.basicstudy.designpattern.newversion.abstract_factory;

public class XiaoMiPhoneProduct implements IPhoneProduct {

  @Override
  public void call() {
    System.out.println("小米手机call");
  }

  @Override
  public void start() {
    System.out.println("小米手机开机");
  }
}
