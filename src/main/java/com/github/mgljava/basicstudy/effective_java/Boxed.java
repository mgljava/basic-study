package com.github.mgljava.basicstudy.effective_java;

/**
 * 6. 避免创建不必要的对象
 */
public class Boxed {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    long sum = sum();
    /*
    如果采用 Long类型 返回值为：sum is : 2305843005992468481 ,times: 6544
    由于在计算的过程中都会创建Long类型的实例，导致创建的实例无用
     */
    System.out.println("sum is : " + sum + " ,times: " + (System.currentTimeMillis() - start));
    // 如果采用 long类型，返回值为：sum is : 2305843005992468481 ,times: 585
  }

  // 尽量不采用包装数据类型就不采用
  private static long sum() {
    long sum = 0L;
    for (long i = 0; i < Integer.MAX_VALUE; i++) {
      sum += i;
    }
    return sum;
  }
}
