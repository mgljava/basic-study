package com.github.mgljava.basicstudy.leetcode;

/**
 * 爬楼梯问题
 * <br>
 * 动态规划
 * <br>
 * 滚动数组
 */
public class ClimbStairs {

  public static void main(String[] args) {
    System.out.println(new ClimbStairs().climbStairs2(1000));
  }

  public int climbStairs3(int n) {
    int f1 = 1, f2 = 2, f3 = 3;
    if (n <= 2) {
      return n;
    }
    for (int i = 3; i <= n; i++) {
      f3 = f1 + f2;
      f1 = f2;
      f2 = f3;
    }
    return f3;
  }

  // 记忆递归 时间复杂度 O(n)
  public int climbStairs2(int n) {
    int memo[] = new int[n + 1];
    return climbStairsMemo(n, memo);
  }

  private int climbStairsMemo(int n, int[] memo) {
    if (memo[n] > n) {
      return memo[n];
    }
    if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 2;
    } else {
      memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
    }
    return memo[n];
  }


  // 一般递归
  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 2;
    }
    return climbStairs(n - 1) + climbStairs(n - 2);
  }
}
