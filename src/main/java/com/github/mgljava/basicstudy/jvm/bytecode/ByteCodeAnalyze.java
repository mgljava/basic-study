package com.github.mgljava.basicstudy.jvm.bytecode;

public class ByteCodeAnalyze {

  /**
   * 对于静态代码块和静态成员变量含有初始值的情况，赋值都是在 <clinit>方法中执行的
   */
  static {
    System.out.println("Wll");
  }

  /**
   * 如果成员变量有赋初始值，那么该变量的值都是在构造方法中赋值的，构造方法执行的方法为 <init>
   * 如果有多个构造方法，那么多个构造方法都会对变量赋值
   */
  String str = "Welcome";

  private int x = 5;

  public static Integer in = 10;

  public static void main(String[] args) {
    ByteCodeAnalyze byteCodeAnalyze = new ByteCodeAnalyze();
    byteCodeAnalyze.setX(8);

    in = 20;
  }

  public void setX(int x) {
    synchronized (this) {
      this.x = x;
    }
  }

  static {
    System.out.println("Hello");
  }
}
