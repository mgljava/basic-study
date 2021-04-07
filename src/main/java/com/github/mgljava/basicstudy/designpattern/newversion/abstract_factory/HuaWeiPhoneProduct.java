package com.github.mgljava.basicstudy.designpattern.newversion.abstract_factory;

public class HuaWeiPhoneProduct implements IPhoneProduct {

  @Override
  public void call() {
    System.out.println("HUAWEI手机call");
  }

  @Override
  public void start() {
    System.out.println("HUAWEI手机开机");
  }
}
