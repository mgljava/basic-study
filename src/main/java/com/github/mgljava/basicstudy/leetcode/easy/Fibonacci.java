package com.github.mgljava.basicstudy.leetcode.easy;

// 斐波拉契数列问题
public class Fibonacci {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    // int result = new Fibonacci().fib2(40, new int[51]); // 102334155
    // int result = new Fibonacci().fib1(40); // 102334155
    int result = new Fibonacci().fib3(45);    // 134903163
    System.out.println(result);
    System.out.println("cost : " + (System.currentTimeMillis() - start));
  }

  /**
   * 1. 一般的递归方式
   */
  public int fib1(int num) {
    if (num <= 1) {
      return num;
    }
    return fib1(num - 1) + fib1(num - 2);
  }

  /**
   * 2. 带记忆的递归方式
   */
  public int fib2(int num, int[] memo) {
    if (num <= 1) {
      return num;
    } else if (memo[num] == 0) {
      memo[num] = fib2(num - 1, memo) + fib2(num - 2, memo);
    }
    return memo[num];
  }

  /**
   * 3. 动态规划, 状态转移方程：dp[i] = dp[i - 1] + dp[i - 2]; 对结果进行取模运算
   */
  public int fib3(int n) {
    if (n <= 0) {
      return n;
    }
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
      dp[i] %= 1000000007;
    }
    return dp[n];
  }
}
