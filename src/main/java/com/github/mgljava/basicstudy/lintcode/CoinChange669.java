package com.github.mgljava.basicstudy.lintcode;

public class CoinChange669 {

  public static void main(String[] args) {
    int i = new CoinChange669().coinChange(new int[] {1, 2, 5}, 11);
    System.out.println(i);
  }
  // 输入为 2，5，7 target为27
  // 则 f(27) = min(f(27-2) + 1, f(27-5) + 1, f(27-7) + 1)
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
      dp[i] = Integer.MAX_VALUE;
      for (int coin : coins) {
        if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
        }
      }
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }
}
