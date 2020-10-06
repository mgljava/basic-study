package com.github.mgljava.basicstudy.leetcode.easy;

public class HouseRobber {

  public static void main(String[] args) {
    int rob = new HouseRobber().rob(new int[] {2, 7, 9, 3, 1});
    System.out.println(rob);
  }

  public int rob(int[] nums) {

    int n = nums.length;
    if (n == 0) {
      return 0;
    }

    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int v = nums[i];
      dp[i + 1] = Math.max(dp[i - 1] + v, dp[i]);
    }
    return dp[n];
  }
}
