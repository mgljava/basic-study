package com.github.mgljava.basicstudy.leetcode.easy;

public class BestTimeBuyStock121 {

  public static void main(String[] args) {
    int result = new BestTimeBuyStock121().maxProfit(new int[] {7, 1, 5, 3, 6, 4});
    System.out.println(result);
  }

  // 差分数组
  public int maxProfit(int[] prices) {
    int length = prices.length;
    if (length < 2) {
      return 0;
    }
    int[] diff = new int[length - 1];
    for (int i = 0; i < length - 1; i++) {
      diff[i] = prices[i + 1] - prices[i];
    }

    int[] dp = new int[length - 1];
    dp[0] = diff[0];
    for (int i = 1; i < length - 1; i++) {
      dp[i] = Math.max(diff[i], dp[i - 1] + diff[i]);
    }
    int res = 0;
    for (int i = 0; i < length - 1; i++) {
      res = Math.max(res, dp[i]);
    }
    return res;
  }
}
