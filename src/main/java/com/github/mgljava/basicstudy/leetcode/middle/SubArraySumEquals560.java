package com.github.mgljava.basicstudy.leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEquals560 {

  public static void main(String[] args) {
    int i = new SubArraySumEquals560().subarraySum(new int[] {1, 1, 1, 1, 3, 1, 1}, 2);
    System.out.println(i);
  }

  public int subarraySum(int[] nums, int k) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    int ans = 0;
    int sum = 0;
    map.put(0, 1);
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      int count = map.getOrDefault(sum - k, 0);
      if (count > 0) {
        ans += count;
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return ans;
  }
}
