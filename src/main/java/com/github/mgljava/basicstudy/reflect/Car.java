package com.github.mgljava.basicstudy.reflect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuppressWarnings(value = "aaa")
public class Car {

  private String brand;
  private String color;
  private Integer speed;

  public Integer age;
}
