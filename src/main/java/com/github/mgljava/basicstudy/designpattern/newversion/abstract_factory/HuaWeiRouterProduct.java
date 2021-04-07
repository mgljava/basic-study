package com.github.mgljava.basicstudy.designpattern.newversion.abstract_factory;

public class HuaWeiRouterProduct implements IRouterProduct {

  @Override
  public void openWifi() {
    System.out.println("HUAWEI路由器打开WIFI");
  }

  @Override
  public void setting() {
    System.out.println("HUAWEI路由器设置");
  }
}
