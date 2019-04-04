package com.github.mgljava.basicstudy.designpattern.proxy.dynamic;

public class CityFacadeImpl implements CityFacade {

  @Override
  public void addCity() {
    System.out.println("增加城市的方法...");
  }
}
