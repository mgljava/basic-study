package com.github.mgljava.basicstudy.leetcode.middle;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public class Triangle120 {

  public static void main(String[] args) {
    List<List<Integer>> triangle = new ArrayList<>();
    triangle.add(ImmutableList.of(2));
    triangle.add(ImmutableList.of(3, 4));
    triangle.add(ImmutableList.of(6, 5, 7));
    triangle.add(ImmutableList.of(4, 1, 8, 3));
    int i = new Triangle120().minimumTotal(triangle);
    System.out.println(i);
  }

  /**
   * 状态转移方程：dp[i][j] = min(dp[i+1][j], dp[i+1][j+1]) + dp[i][j] 自底向上求解
   *
   * @param triangle
   * @return
   */
  public int minimumTotal(List<List<Integer>> triangle) {

    int[] ans = new int[triangle.size() + 1];
    for (int i = triangle.size() - 1; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        ans[j] = Math.min(ans[j], ans[j + 1]) + triangle.get(i).get(j);
      }
    }
    return ans[0];
  }
}
