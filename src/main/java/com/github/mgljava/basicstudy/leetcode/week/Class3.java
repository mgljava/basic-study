package com.github.mgljava.basicstudy.leetcode.week;

import java.util.ArrayList;
import java.util.List;

public class Class3 {

  public static void main(String[] args) {
    int i = new Class3().minimumEffortPath(new int[][] {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}});
    System.out.println(i);
  }
  public int minimumEffortPath(int[][] heights) {
    // dp[i][j] = Math.min(dp[i][j-1], dp[i][j+1], dp[i-1][j], dp[i+1][j]);
    // dp[0][0] = heights[0][0];
    List<Integer> res = new ArrayList<>();
    for (int i = 1; i < heights.length; i++) {
      for (int j = 1; j < heights[i].length; j++) {
        dfs(res, heights, i, j);
      }
    }
    return res.size();
  }

  public int dfs(List<Integer> res, int[][] heights, int i, int j) {
    if (i <= 0 || j <= 0 || i >= heights.length || j > heights[i].length) {
      res.add(heights[i][j]);
      return 1;
    }
    int left = dfs(res, heights, i - 1, j);
    int right = dfs(res, heights, i + 1, j);
    int top = dfs(res, heights, i, j - 1);
    int botumn = dfs(res, heights, i, j + 1);
    return Math.min(Math.min(left, right), Math.min(top, botumn));
  }
}
