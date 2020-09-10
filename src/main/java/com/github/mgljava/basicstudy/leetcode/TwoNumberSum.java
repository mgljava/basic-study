package com.github.mgljava.basicstudy.leetcode;

import java.util.Arrays;

/**
 * <p>给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。</p>
 *
 * <p>你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍</p>
 */
public class TwoNumberSum {

  public static void main(String[] args) {
    int[] numbers = new int[] {3, 2, 4};
    int[] ints = new TwoNumberSum().twoSum(numbers, 6);
    Arrays.stream(ints).forEach(System.out::println);
  }

  public int[] twoSum(int[] nums, int target) {
    int[] ans = new int[2];
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          ans[0] = i;
          ans[1] = j;
          return ans;
        }
      }
    }
    return new int[] {-1, -1};
  }
}
