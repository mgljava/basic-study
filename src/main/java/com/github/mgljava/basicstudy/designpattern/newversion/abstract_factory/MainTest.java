package com.github.mgljava.basicstudy.designpattern.newversion.abstract_factory;

public class MainTest {

  public static void main(String[] args) {
    System.out.println("---------小米系列---------");
    AbstractFactory abstractFactory = new XiaoMiFactory();
    IPhoneProduct iPhoneProduct = abstractFactory.productPhone();
    iPhoneProduct.start();
    iPhoneProduct.call();

    IRouterProduct iRouterProduct = abstractFactory.productRouter();
    iRouterProduct.openWifi();
    iRouterProduct.setting();

    System.out.println("---------HUAWEI系列---------");
    abstractFactory = new HuaWeiFactory();
    IPhoneProduct iPhoneProduct1 = abstractFactory.productPhone();
    iPhoneProduct1.start();
    iPhoneProduct1.call();
    IRouterProduct iRouterProduct1 = abstractFactory.productRouter();
    iRouterProduct1.openWifi();
    iRouterProduct1.setting();
  }
}
