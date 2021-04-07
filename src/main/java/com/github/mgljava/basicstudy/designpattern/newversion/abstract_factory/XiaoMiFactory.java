package com.github.mgljava.basicstudy.designpattern.newversion.abstract_factory;

public class XiaoMiFactory implements AbstractFactory{

  @Override
  public IPhoneProduct productPhone() {
    return new XiaoMiPhoneProduct();
  }

  @Override
  public IRouterProduct productRouter() {
    return new XiaoMiRouterProduct();
  }
}
