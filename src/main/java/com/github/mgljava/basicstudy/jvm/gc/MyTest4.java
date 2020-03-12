package com.github.mgljava.basicstudy.jvm.gc;

/**
 * -verbose:gc
 * -Xmx200M
 * -Xmn50M
 * -XX:TargetSurvivorRatio=60
 * -XX:+PrintTenuringDistribution
 * -XX:+PrintGCDetails -XX:+PrintGCDateStamps
 * -XX:+UseConcMarkSweepGC
 * -XX:+UseParNewGC
 * -XX:MaxTenuringThreshold=3
 */

public class MyTest4 {

  public static void main(String[] args) throws InterruptedException {
    byte[] byte_1 = new byte[512 * 1024];
    byte[] byte_2 = new byte[512 * 1024];

    myGc();
    Thread.sleep(1000);
    System.out.println("11111");
    myGc();
    Thread.sleep(1000);
    System.out.println("22222");

    myGc();
    Thread.sleep(1000);
    System.out.println("33333");

    myGc();
    Thread.sleep(1000);
    System.out.println("44444");

    byte[] byte_3 = new byte[1024 * 1024];
    byte[] byte_4 = new byte[1024 * 1024];
    byte[] byte_5 = new byte[1024 * 1024];

    myGc();
    Thread.sleep(1000);
    System.out.println("55555");

    myGc();
    Thread.sleep(1000);
    System.out.println("66666");

    System.out.println("Hello world!");
  }

  private static void myGc() {
    for (int i = 0; i < 40; i++) {
      byte[] bytes = new byte[1024 * 1024];
    }
  }
}

/*
输出结果：
2020-03-12T13:34:42.418-0800: [GC (Allocation Failure) 2020-03-12T13:34:42.418-0800: [ParNew
Desired survivor size 3145728 bytes, new threshold 3 (max 3)
- age   1:    1832352 bytes,    1832352 total
: 39953K->1820K(46080K), 0.0020850 secs] 39953K->1820K(199680K), 0.0021294 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
11111
2020-03-12T13:34:43.425-0800: [GC (Allocation Failure) 2020-03-12T13:34:43.425-0800: [ParNew
Desired survivor size 3145728 bytes, new threshold 3 (max 3)
- age   1:     347632 bytes,     347632 total
- age   2:    1692024 bytes,    2039656 total
: 41942K->2398K(46080K), 0.0013384 secs] 41942K->2398K(199680K), 0.0013723 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
22222
2020-03-12T13:34:44.430-0800: [GC (Allocation Failure) 2020-03-12T13:34:44.431-0800: [ParNew
Desired survivor size 3145728 bytes, new threshold 3 (max 3)
- age   1:         56 bytes,         56 total
- age   2:     346920 bytes,     346976 total
- age   3:    1688384 bytes,    2035360 total
: 42907K->2386K(46080K), 0.0015162 secs] 42907K->2386K(199680K), 0.0015624 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
33333
2020-03-12T13:34:45.441-0800: [GC (Allocation Failure) 2020-03-12T13:34:45.441-0800: [ParNew
Desired survivor size 3145728 bytes, new threshold 3 (max 3)
- age   1:         56 bytes,         56 total
- age   2:         56 bytes,        112 total
- age   3:     346944 bytes,     347056 total
: 43104K->1016K(46080K), 0.0039228 secs] 43104K->2686K(199680K), 0.0039623 secs] [Times: user=0.01 sys=0.01, real=0.00 secs]
44444
2020-03-12T13:34:46.452-0800: [GC (Allocation Failure) 2020-03-12T13:34:46.452-0800: [ParNew
Desired survivor size 3145728 bytes, new threshold 1 (max 3)
- age   1:    3145832 bytes,    3145832 total
- age   2:         56 bytes,    3145888 total
- age   3:         56 bytes,    3145944 total
: 41741K->3149K(46080K), 0.0014432 secs] 43411K->5179K(199680K), 0.0014775 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
55555
2020-03-12T13:34:47.461-0800: [GC (Allocation Failure) 2020-03-12T13:34:47.461-0800: [ParNew
Desired survivor size 3145728 bytes, new threshold 3 (max 3)
- age   1:         56 bytes,         56 total
: 43880K->9K(46080K), 0.0026233 secs] 45909K->5111K(199680K), 0.0026572 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
66666
Hello world!
Heap
 par new generation   total 46080K, used 20058K [0x00000007b3800000, 0x00000007b6a00000, 0x00000007b6a00000)
  eden space 40960K,  48% used [0x00000007b3800000, 0x00000007b4b943e8, 0x00000007b6000000)
  from space 5120K,   0% used [0x00000007b6000000, 0x00000007b60026d0, 0x00000007b6500000)
  to   space 5120K,   0% used [0x00000007b6500000, 0x00000007b6500000, 0x00000007b6a00000)
 concurrent mark-sweep generation total 153600K, used 5101K [0x00000007b6a00000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace       used 3643K, capacity 4536K, committed 4864K, reserved 1056768K
  class space    used 398K, capacity 428K, committed 512K, reserved 1048576K

Process finished with exit code 0

 */