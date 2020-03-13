package com.github.mgljava.basicstudy.jvm.gc;

/**
 * CMS收集器的收集过程
 * GC参数：
 *  -verbose:gc
 * -Xmx20M
 * -Xms20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 * -XX:+UseConcMarkSweepGC
 *
 * 默认情况下，如果老年代使用CMS收集器，那么新生代JVM自动选择ParNew收集器
 */
public class CMSTest {

  public static void main(String[] args) {
    int size = 1024 * 1024;

    byte[] myAlloc1 = new byte[5 * size];
    System.out.println("1111");
    byte[] myAlloc2 = new byte[5* size];
    System.out.println("2222");
    byte[] myAlloc3 = new byte[4 * size];
    System.out.println("3333");
    byte[] myAlloc4 = new byte[2 * size];
    System.out.println("4444");
  }
}
/*
1111
[GC (Allocation Failure) [ParNew: 7957K->782K(9216K), 0.0048134 secs] 7957K->5904K(19456K), 0.0048928 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2222
[GC (Allocation Failure) [ParNew: 6142K->6142K(9216K), 0.0000384 secs][CMS: 5122K->5120K(10240K), 0.0026435 secs] 11264K->10858K(19456K), [Metaspace: 2980K->2980K(1056768K)], 0.0027097 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
[GC (CMS Initial Mark) [1 CMS-initial-mark: 9216K(10240K)] 14954K(19456K), 0.0004826 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
[CMS-concurrent-mark-start]
3333
[CMS-concurrent-mark: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[CMS-concurrent-preclean-start]
[CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[CMS-concurrent-abortable-preclean-start]
[CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (CMS Final Remark) [YG occupancy: 8163 K (9216 K)][Rescan (parallel) , 0.0007491 secs][weak refs processing, 0.0000156 secs][class unloading, 0.0001856 secs][scrub symbol table, 0.0002311 secs][scrub string table, 0.0001388 secs][1 CMS-remark: 9216K(10240K)] 17379K(19456K), 0.0013595 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[CMS-concurrent-sweep-start]
4444[CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]

[CMS-concurrent-reset-start]
[CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
Heap
 par new generation   total 9216K, used 8192K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
  eden space 8192K, 100% used [0x00000007bec00000, 0x00000007bf400000, 0x00000007bf400000)
  from space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
  to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
 concurrent mark-sweep generation total 10240K, used 9216K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace       used 3019K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 328K, capacity 388K, committed 512K, reserved 1048576K

Process finished with exit code 0

 */