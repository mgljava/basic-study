package com.github.mgljava.basicstudy.designpattern.newversion.abstract_factory;

public class HuaWeiFactory implements AbstractFactory {

  @Override
  public IPhoneProduct productPhone() {
    return new HuaWeiPhoneProduct();
  }

  @Override
  public IRouterProduct productRouter() {
    return new HuaWeiRouterProduct();
  }
}
