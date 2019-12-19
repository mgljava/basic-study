package com.github.mgljava.basicstudy.jvm.classloader;

public class MyTest15 {

  public static void main(String[] args) {
    String[] strings = new String[2];

    System.out.println(strings.getClass()); // class [Ljava.lang.String;
    System.out.println(strings.getClass().getClassLoader()); // null  使用根加载器加载
    System.out.println("---------------------");

    MyTest15[] myTest15s = new MyTest15[1];
    System.out.println(myTest15s.getClass()); // class [Lcom.github.mgljava.basicstudy.jvm.classloader.MyTest15;
    System.out.println(myTest15s.getClass().getClassLoader()); // sun.misc.Launcher$AppClassLoader@18b4aac2，本类的加载器采用App类加载器加载

    System.out.println("---------------------");
    int[] ints = new int[2];
    System.out.println(ints.getClass()); // class [I
    System.out.println(ints.getClass().getClassLoader()); // null  原生数据类型没有类加载器

    System.out.println("---------------------");
    Integer[] integers = new Integer[2];
    System.out.println(integers.getClass()); // class [Ljava.lang.Integer;
    System.out.println(integers.getClass().getClassLoader()); //null 使用根加载器加载
  }
}
