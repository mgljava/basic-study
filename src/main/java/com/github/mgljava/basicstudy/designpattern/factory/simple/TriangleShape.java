package com.github.mgljava.basicstudy.designpattern.factory.simple;

// 三角形
public class TriangleShape implements Shape {

  public TriangleShape() {
    System.out.println("TriangleShape: created");
  }

  @Override
  public void draw() {
    System.out.println("draw: TriangleShape");
  }
}
