package com.github.mgljava.basicstudy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CarReflectTest {

  public static void main(String[] args) throws Exception {
    System.out.println(getCar());
    System.out.println("------------------");
    System.out.println(getCar2());
    System.out.println("------------------");
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    final Class<?> aClass = classLoader.loadClass("com.github.mgl.reflect.Car");
    Arrays.stream(aClass.getDeclaredFields())
        .forEach(item -> System.out.println(item.getName()));
  }


  private static Car getCar() throws Exception {
    final Class<?> clazz = Class.forName("com.github.mgl.reflect.Car");
    final Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
    Car car = (Car) declaredConstructor.newInstance();
    car.setBrand("HB");
    car.setColor("Red");
    car.setSpeed(2000);
    return car;
  }

  private static Car getCar2() throws Exception {
    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    final Class<?> clazz = classLoader.loadClass("com.github.mgl.reflect.Car");
    final Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
    Car car = (Car) declaredConstructor.newInstance();

    Method setBrand = clazz.getMethod("setBrand", String.class);
    setBrand.invoke(car, "BMW");

    Method setColor = clazz.getMethod("setColor", String.class);
    setColor.invoke(car, "Green");

    Method setSpeed = clazz.getMethod("setSpeed", Integer.class);
    setSpeed.invoke(car, 3000);
    return car;
  }
}
