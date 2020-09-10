package com.github.mgljava.basicstudy.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 给一个有序数组，给定一个目标值，找到于这个值最相近的两个数
public class FindTwoWords {

  public static void main(String[] args) {
    int[] numbers = new int[] {1, 9, 14, 18, 27, 35, 36, 48, 68, 80, 86, 92, 99};
    List<Integer> integers = printNumber(numbers, 40);
    System.out.println(integers);
  }

  public static List<Integer> printNumber(int[] arr, int target) {
    List<Integer> ret = Arrays.stream(arr).boxed()
        .sorted((a, b) -> a.equals(b) ? 0 : Math.abs(a - target) - Math.abs(b - target))
        .collect(Collectors.toList());
    ret = ret.subList(0, 2);
    //Collections.sor总结t(ret);
    return ret;
  }
}
