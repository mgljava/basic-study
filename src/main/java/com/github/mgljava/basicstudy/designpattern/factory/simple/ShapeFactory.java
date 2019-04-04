package com.github.mgljava.basicstudy.designpattern.factory.simple;

/**
 * Shape工厂类的具体实现
 */
public class ShapeFactory {

  public static Shape getShape(String type) {
    Shape shape = null;
    if (type.equalsIgnoreCase("circle")) {
      shape = new CircleShape();
    } else if (type.equalsIgnoreCase("rect")) {
      shape = new RectShape();
    } else if (type.equalsIgnoreCase("triangle")) {
      shape = new TriangleShape();
    }
    return shape;
  }
}
