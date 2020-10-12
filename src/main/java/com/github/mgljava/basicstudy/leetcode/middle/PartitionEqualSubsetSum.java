package com.github.mgljava.basicstudy.leetcode.middle;

public class PartitionEqualSubsetSum {

  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 != 0) {
      return false;
    }
    int target = sum / 2;

    boolean[] dp = new boolean[target + 1];
    dp[0] = true;
    for (int num : nums) {
      for (int j = target; j >= num; j--) {
        dp[j] |= dp[j - num];
      }
    }
    return dp[target];
  }

  public static void main(String[] args) {
    boolean b = new PartitionEqualSubsetSum().canPartition(new int[] {14, 9, 8, 4, 3, 2});
    System.out.println(b);
  }
}
