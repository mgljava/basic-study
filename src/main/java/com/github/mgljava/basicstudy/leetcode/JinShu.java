package com.github.mgljava.basicstudy.leetcode;

// 1,2,3  4
public class JinShu {

  public static void main(String[] args) {
    JinShu jinShu = new JinShu();
    System.out.println(jinShu.compose(new int[] {3, 2, 1}, 39));
  }

  /**
   * 11111 1112 113 122 23
   */
  public int compose(int[] nums, int k) {
    int[] f = new int[k + 1];
    f[0] = 1;
    for (int i = 0; i < nums.length; i++) {
      int c = nums[i];
      for (int j = c; j <= k; ++j) {
        f[j] = f[j] + f[j - c];
      }
    }
    return f[k];
  }
}
