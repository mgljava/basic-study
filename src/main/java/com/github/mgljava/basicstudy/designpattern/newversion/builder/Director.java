package com.github.mgljava.basicstudy.designpattern.newversion.builder;

// 指挥者
public class Director {

  public void makeDirector(ProductBuilder builder) {
    builder.builderPartA();
    builder.builderPartB();
  }
}
