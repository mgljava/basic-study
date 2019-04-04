package com.github.mgljava.basicstudy.designpattern.factory.simple;

// 圆形
public class CircleShape implements Shape {

  public CircleShape() {
    System.out.println("CircleShape: created");
  }

  @Override
  public void draw() {
    System.out.println("draw: CircleShape");
  }
}
