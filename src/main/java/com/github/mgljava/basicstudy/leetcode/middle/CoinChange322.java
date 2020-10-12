package com.github.mgljava.basicstudy.leetcode.middle;

public class CoinChange322 {

  public static void main(String[] args) {
    int func = new CoinChange322().coinChange(new int[] {1, 2, 3}, 4);
    System.out.println(func);
  }

  // 给定不同面额的硬币 coins 和一个总金额 amount。
  // 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
  public int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    int ans = Integer.MAX_VALUE;
    for (int num : coins) {
      if (amount - num < 0) {
        continue;
      }
      int subPro = coinChange(coins, amount - num);
      if (subPro == -1) {
        continue;
      }
      ans = Math.min(ans, subPro + 1);
    }
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }
}
