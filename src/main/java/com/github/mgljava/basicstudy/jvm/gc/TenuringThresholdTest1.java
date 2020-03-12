package com.github.mgljava.basicstudy.jvm.gc;

/**
 * 当对象经过多次回收之后，如果还存活，那么就进入到老年代
 * -verbose:gc
 * -Xms20m
 * -Xmx20m
 * -Xmn10m
 * -XX:+PrintGCDetails
 * -XX:+PrintCommandLineFlags : 打印命令行的标识，打印JVM启动参数
 * -XX:MaxTenuringThreshold=5 : 主要是控制新生代需要经历多少次GC晋升到老年代中的最大阈值，因为在对象头中有4个bit来存储对象的分代年龄，所以默认为15
 * -XX:+PrintTenuringDistribution : 丰富了gclog部分
 *
 * 在经历了多次GC后，存活的对象会在From Survivor与To Survivor之间来回存放，而这里面的一个前提则是这两个空间由足够的大小来存放这些数据，在GC算法中，
 * 会计算每个对象年龄的大小，如果达到某个年龄后发现总大小已经大于了Survivor空间的50%，那么这时就需要调整阈值，不能再继续等到默认的15次GC后才完成晋升，
 * 因为这样会导致Survivor空间不足，所以需要调整阈值，让这些存活对象尽快完成晋升。
 */
public class TenuringThresholdTest1 {

  public static void main(String[] args) {
    int size = 1024 * 1024;

    byte[] myAlloc1 = new byte[2 * size];
    byte[] myAlloc2 = new byte[2 * size];
    byte[] myAlloc3 = new byte[2 * size];
    byte[] myAlloc4 = new byte[2 * size];
    System.out.println("Hello World!");
  }
}
