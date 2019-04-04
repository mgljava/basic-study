package com.github.mgljava.basicstudy.designpattern.factory.simple;

public class MainTest {

  public static void main(String[] args) {

    Shape circle = ShapeFactory.getShape("circle");
    circle.draw();

    Shape rect = ShapeFactory.getShape("rect");
    rect.draw();
  }
}
