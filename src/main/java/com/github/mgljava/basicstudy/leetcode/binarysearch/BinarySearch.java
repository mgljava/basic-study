package com.github.mgljava.basicstudy.leetcode.binarysearch;

import java.util.Arrays;
import java.util.List;

// 二分查找
public class BinarySearch {

  public static void main(String[] args) {
    int search = binarySearch(Arrays.asList(1, 4, 6, 7, 34, 22, 89, 65, 332), 14);
    System.out.println(search);
  }

  public static int binarySearch(List<Integer> lists, int target) {
    int left = 0;
    int right = lists.size() - 1;
    while (left <= right) {
      int mid = (right + left) / 2;
      if (lists.get(mid) == target) {
        return mid;
      } else if (lists.get(mid) < target) {
        left = mid + 1;
      } else if (lists.get(mid) > target) {
        right = mid - 1;
      }
    }
    return right;
  }
}
