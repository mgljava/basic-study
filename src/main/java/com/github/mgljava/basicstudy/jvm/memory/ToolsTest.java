package com.github.mgljava.basicstudy.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示堆栈出现的错误
 * <p>
 * 设置堆空间的大小：-Xms5m -Xmx5m 设置栈空间的大小：
 */
public class ToolsTest {

  private int length;

  public int getLength() {
    return length;
  }

  public static void main(String[] args) {
    // heapTest();
    ToolsTest toolsTest = new ToolsTest();
    try {
      toolsTest.stackOverFlow();
    } catch (Throwable t) {
      System.out.println(toolsTest.getLength());
      t.printStackTrace();
    }
  }

  private void stackOverFlow() {
    this.length++;
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    stackOverFlow();
  }

  // 堆溢出演示
  private static void heapTest() {
    List<ToolsTest> list = new ArrayList<>();
    for (; ; ) {
      list.add(new ToolsTest());

      System.gc(); // 显示调用，告诉JVM进行垃圾回收
    }
  }
}
