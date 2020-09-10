package com.github.mgljava.basicstudy.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FindTwoWords2 {

  public static void main(String[] args) {
    int[] numbers = new int[] {1, 9, 14, 18, 27, 35, 36, 48, 68, 80, 86, 92, 99};
    System.out.println(findClosestElements(numbers, 2, 40));
  }

  public static List<Integer> findClosestElements(int[] arr, int k, int target) {
    int left = 0, right = arr.length - k;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (target - arr[mid] > arr[mid + k] - target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    //以l作为起始索引，长度为k
    List<Integer> res = new LinkedList<>();
    for (int i = 0; i < k; i++) {
      res.add(arr[i + left]);
    }
    return res;
    /*List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
    int n = ret.size();
    if (target <= ret.get(0)) {
      return ret.subList(0, k);
    } else if (ret.get(n - 1) <= target) {
      return ret.subList(n - k, n);
    } else {
      int index = Collections.binarySearch(ret, target);
      if (index < 0) {
        index = -index - 1;
      }
      int low = Math.max(0, index - k - 1);
      int high = Math.min(ret.size() - 1, index + k - 1);
      while (high - low > k - 1) {
        if ((target - ret.get(low)) <= (ret.get(high) - target)) {
          high--;
        } else if ((target - ret.get(low)) > (ret.get(high) - target)) {
          low++;
        } else {
          System.out.println("unhandled case: " + low + " " + high);
        }
      }
      return ret.subList(low, high + 1);
    }*/
  }
}
