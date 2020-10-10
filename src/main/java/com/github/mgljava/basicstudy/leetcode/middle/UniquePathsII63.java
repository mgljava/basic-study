package com.github.mgljava.basicstudy.leetcode.middle;

public class UniquePathsII63 {

  public static void main(String[] args) {
    int i = new UniquePathsII63().uniquePathsWithObstacles(new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
    System.out.println(i);
  }

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    // dp[i][j] = dp[i+1][j] + dp[i][j+1]
    int width = obstacleGrid[0].length;
    int[] dp = new int[width];

    dp[0] = 1;
    for (int[] row : obstacleGrid) {
      for (int j = 0; j < width; j++) {
        if (row[j] == 1) {
          dp[j] = 0;
        } else if (j > 0) {
          dp[j] += dp[j - 1];
        }
      }
    }
    return dp[width - 1];
  }
}
