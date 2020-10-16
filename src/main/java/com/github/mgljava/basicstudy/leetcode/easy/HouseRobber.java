package com.github.mgljava.basicstudy.leetcode.easy;

public class HouseRobber {

  public static void main(String[] args) {
    int rob = new HouseRobber().rob(new int[] {2, 7, 9, 3, 1});
    System.out.println(rob);
  }

  // 动态规划
  public int rob2(int[] nums) {
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


  public int rob(int[] nums) {

    int n = nums.length;
    if (n == 0) {
      return 0;
    }

    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = nums[0];
    for (int i = 2; i < nums.length; i++) {
      int v = nums[i];
      dp[i] = Math.max(dp[i-2]+v, dp[i]);
      // dp[i + 1] = Math.max(dp[i - 1] + v, dp[i]);
    }
    return dp[n];
  }
}
