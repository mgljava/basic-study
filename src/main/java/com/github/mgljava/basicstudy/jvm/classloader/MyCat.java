package com.github.mgljava.basicstudy.jvm.classloader;

public class MyCat {

  public MyCat() {
    System.out.println("MyCat is loaded by : " + this.getClass().getClassLoader());
  }
}
