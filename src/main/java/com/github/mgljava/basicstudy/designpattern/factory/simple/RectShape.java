package com.github.mgljava.basicstudy.designpattern.factory.simple;

// 正方形
public class RectShape implements Shape {

  public RectShape() {
    System.out.println("RectShape: created");
  }

  @Override
  public void draw() {
    System.out.println("draw: RectShape");
  }
}
