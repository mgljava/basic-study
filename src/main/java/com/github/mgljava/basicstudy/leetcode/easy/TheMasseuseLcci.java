package com.github.mgljava.basicstudy.leetcode.easy;

// 按摩师
public class TheMasseuseLcci {

  public int massage(int[] nums) {
    int length = nums.length;
    if (length == 0) {
      return 0;
    }

    int[] dp = new int[length + 1];
    dp[0] = 0;
    dp[1] = nums[0];
    for (int i = 1; i < length; i++) {
      dp[i + 1] = Math.max(dp[i - 1] + nums[i], dp[i]);
    }
    return dp[length];
  }
}
