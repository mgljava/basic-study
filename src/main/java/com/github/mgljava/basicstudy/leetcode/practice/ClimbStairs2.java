package com.github.mgljava.basicstudy.leetcode.practice;

public class ClimbStairs2 {

  public static void main(String[] args) {
    int i = new ClimbStairs2().climbStairs(4);
    System.out.println(i);
  }

  // dp[i] = dp[i-1] + dp[i-2]
  public int climbStairs(int n) {
    if (n <= 2) {
      return n;
    }
    int[] dp = new int[n];
    dp[0] = 1;
    dp[1] = 2;
    for (int i = 2; i < n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n - 1];
  }
}
