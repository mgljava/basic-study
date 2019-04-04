package com.github.mgljava.basicstudy.java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // lombok 注解
@AllArgsConstructor
public class Dish {

  private String name;
  private boolean vegetarian;
  private int calories;
  private Type type;

  enum Type {
    MEAT, FISH, OTHER
  }
}

