package com.github.mgljava.basicstudy.designpattern.newversion.builder;

public class MainTest {

  public static void main(String[] args) {
    Director director = new Director();
    ConcreteProductBuilder1 builder1 = new ConcreteProductBuilder1();
    director.makeDirector(builder1);
    Product product = builder1.getProduct();
    product.show();

    ConcreteProductBuilder2 builder2 = new ConcreteProductBuilder2();
    director.makeDirector(builder2);
    Product product2 = builder2.getProduct();
    product2.show();
  }
}
