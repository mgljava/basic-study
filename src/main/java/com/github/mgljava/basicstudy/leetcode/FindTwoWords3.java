package com.github.mgljava.basicstudy.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 通过确定左边界来获取元素
public class FindTwoWords3 {

  public static void main(String[] args) {
    int[] numbers = new int[] {1, 9, 14, 18, 27, 35, 36, 48, 68, 80, 86, 92, 99};
    System.out.println(findClosestElements(numbers, 3, 54));
  }

  // 通过找到左边界来获取元素
  public static List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> source = Arrays.stream(arr).boxed().collect(Collectors.toList());
    if (k > arr.length) {
      return source;
    }
    if (x <= arr[0]) {
      return source.subList(0, k);
    }
    if (x >= arr[arr.length - 1]) {
      return source.subList(arr.length - k, arr.length);
    }
    int left = 0;
    int right = arr.length - k;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (Math.abs(x - arr[mid]) > Math.abs(x - arr[mid + k])) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return source.subList(left, left + k);
  }
}
