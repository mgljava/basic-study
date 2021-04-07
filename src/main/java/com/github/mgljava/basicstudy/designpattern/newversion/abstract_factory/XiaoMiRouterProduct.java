package com.github.mgljava.basicstudy.designpattern.newversion.abstract_factory;

public class XiaoMiRouterProduct implements IRouterProduct {

  @Override
  public void openWifi() {
    System.out.println("小米路由器打开WIFI");
  }

  @Override
  public void setting() {
    System.out.println("小米路由器设置");
  }
}
