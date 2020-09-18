package com.github.mgljava.basicstudy.leetcode.middle;

import java.util.Arrays;

public class CoinChange322 {

  // 给定不同面额的硬币 coins 和一个总金额 amount。
  // 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
  public int coinChange(int[] coins, int amount) {
    if (coins.length == 1) {
      return amount == coins[0] ? 1 : -1;
    }
    Arrays.sort(coins);
    for (int i = coins.length - 1; i > 0; i--) {
      int num = coins[i];
      for (int j = i - 1; j > 0; j--) {

      }
    }
    return -1;
  }
}
