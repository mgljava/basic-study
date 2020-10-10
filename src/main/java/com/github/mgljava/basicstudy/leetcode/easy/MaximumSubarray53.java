package com.github.mgljava.basicstudy.leetcode.easy;

/**
 * 给定一个整数数组 nums ， 找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaximumSubarray53 {

  public static void main(String[] args) {
    int result = new MaximumSubarray53().maxSubArray(new int[] {-2, -1});
    System.out.println(result);
  }

  public int maxSubArray(int[] nums) {
    int length = nums.length;
    if (length == 0) {
      return 0;
    } else if (length == 1) {
      return nums[0];
    }
    int[] dp = new int[length];
    dp[0] = nums[0];
    for (int i = 1; i < length; i++) {
      dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
    }
    int res = Integer.MIN_VALUE;
    for (int v : dp) {
      res = Math.max(res, v);
    }
    return res;
  }
}
