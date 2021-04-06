package com.github.mgljava.basicstudy.designpattern.newversion.builder;

// 具体的建造角色
public class ConcreteProductBuilder1 extends ProductBuilder {

  private Product product = new Product();

  @Override
  public void builderPartA() {
    product.add("部件A");
  }

  @Override
  public void builderPartB() {
    product.add("部件B");
  }

  @Override
  public Product getProduct() {
    return product;
  }
}
