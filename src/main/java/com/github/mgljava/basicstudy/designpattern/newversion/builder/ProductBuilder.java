package com.github.mgljava.basicstudy.designpattern.newversion.builder;

// 抽象建造者类
public abstract class ProductBuilder {

  public abstract void builderPartA();

  public abstract void builderPartB();

  public abstract Product getProduct();
}
