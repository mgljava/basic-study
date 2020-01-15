package com.github.mgljava.basicstudy.jvm.bytecode;

/**
 * 对于Java类的实例方法（非static方法）来说，每个方法都有一个隐含的参数 this。
 * 这样就可以在实例方法中访问当前对象的属性以及其他方法
 * 该操作是在编译期间完成的，由javac编译器在编译的时候对this的访问转换为对一个普通实例方法参数的访问
 */
public class ByteCodeAnalyze {

  /*
    对于静态代码块和静态成员变量含有初始值的情况，赋值都是在 <clinit>方法中执行的
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
