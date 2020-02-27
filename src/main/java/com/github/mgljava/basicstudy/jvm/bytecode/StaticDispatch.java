package com.github.mgljava.basicstudy.jvm.bytecode;

/**
 * 方法的静态分派：
 * Grandpa g1 = new Father();
 * 以上代码，g1的静态类型是Grandpa， 实际类型是Father
 *
 * 结论：变量的静态类型是不会发生改变的，但是变量的实际类型是可以发生改变的（多态的体现），实际类型在运行期确定
 */

public class StaticDispatch {

  // 方法重载，是一种静态的行为，在编译期就可以完全确定
  // 方法重写是一种静态的行为
  public void test(Grandpa grandpa) {
    System.out.println("Grandpa");
  }

  public void test(Father father) {
    System.out.println("Father");
  }

  public void test(Son son) {
    System.out.println("Son");
  }

  public static void main(String[] args) {
    StaticDispatch polymorphicTest = new StaticDispatch();
    Grandpa g1 = new Father();
    Grandpa g2 = new Son();

    Father father = new Son();
    polymorphicTest.test(g1);
    polymorphicTest.test(g2);

    polymorphicTest.test(father);
  }
}

class Grandpa {

}

class Father extends Grandpa {

}

class Son extends Father {

}
