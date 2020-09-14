package com.github.mgljava.basicstudy.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public static void main(String[] args) {
    int[] ints = new TwoSum().twoSum(new int[] {2, 7, 11, 15}, 9);
    Arrays.stream(ints).forEach(System.out::println);
  }

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int tar = target - nums[i];
      if (map.containsKey(tar)) {
        return new int[] {map.get(tar), i};
      }
      map.put(nums[i], i);
    }
    return new int[]{-1, -1};
  }
}
