package com.github.mgljava.basicstudy.designpattern.newversion.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品类
 */
public class Product {

  // 产品的组成对象
  private final List<String> compose = new ArrayList<>();

  public void add(String part) {
    compose.add(part);
  }

  public void show() {
    System.out.println(compose.toString());
  }
}
