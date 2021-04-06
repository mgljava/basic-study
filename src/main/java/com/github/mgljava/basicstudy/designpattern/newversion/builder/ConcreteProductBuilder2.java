package com.github.mgljava.basicstudy.designpattern.newversion.builder;

// 具体的建造角色
public class ConcreteProductBuilder2 extends ProductBuilder {

  private Product product = new Product();

  @Override
  public void builderPartA() {
    product.add("部件X");
  }

  @Override
  public void builderPartB() {
    product.add("部件Y");
  }

  @Override
  public Product getProduct() {
    return product;
  }
}
