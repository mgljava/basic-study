package com.github.mgljava.basicstudy.designpattern.newversion.builder;

public class MainTest {

  public static void main(String[] args) {
    ConcreteProductBuilder1 builder1 = new ConcreteProductBuilder1();
    new Director(builder1);
    Product product = builder1.getProduct();
    product.show();

    ConcreteProductBuilder2 builder2 = new ConcreteProductBuilder2();
    new Director(builder2);
    Product product2 = builder2.getProduct();
    product2.show();
  }
}
