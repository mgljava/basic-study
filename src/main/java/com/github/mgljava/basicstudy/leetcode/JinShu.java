package com.github.mgljava.basicstudy.leetcode;

public class JinShu {

  private int sum = 0;

  public static void main(String[] args) {
    int func = new JinShu().func(new int[] {1, 2, 3}, 4);
    System.out.println(func);
  }
  public int func(int[] nums, int k) {
    if (k < 0) {
      return 1;
    }
    for (int i = 0; i < nums.length - 1; i++) {
      sum += func(nums, k - nums[i]);
    }
    return sum;
  }
}
