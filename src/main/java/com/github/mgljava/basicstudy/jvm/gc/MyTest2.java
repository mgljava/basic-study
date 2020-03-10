package com.github.mgljava.basicstudy.jvm.gc;

/**
 * 通过设置对象直接进入老年代的阈值来将生成的对象直接进入老年代
 * -verbose:gc
 * -Xmx20m
 * -Xms20m
 * -Xmn10
 * -XX:+PrintGCDetail
 * -XX:PretenureSizeThreshold=4194304 设置对象的大小如果超过了4194304（单位字节，这里表示4M），那么对象直接进入老年代
 * -XX:+UseSerialGC
 */
public class MyTest2 {

  public static void main(String[] args) {
    int size = 1024 * 1024;
    byte[] allocate1 = new byte[5 * size];

    try {
      Thread.sleep(1000000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
