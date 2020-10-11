package com.github.mgljava.basicstudy.leetcode.middle;

public class LongestCommonSubsequence1143 {

  public static void main(String[] args) {
    int result = new LongestCommonSubsequence1143().longestCommonSubsequence("abcde", "ace");
    System.out.println(result);
  }

  // 动态规划，状态转移方程 -> dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
  public int longestCommonSubsequence(String text1, String text2) {
    if (text1.isEmpty() || text2.isEmpty()) {
      return 0;
    }
    char[] char1 = text1.toCharArray();
    char[] char2 = text2.toCharArray();
    int length1 = char1.length; // 5
    int length2 = char2.length; // 3
    int[][] dp = new int[length1 + 1][length2 + 1]; // 6 4
    for (int i = 1; i < length1 + 1; i++) {
      for (int j = 1; j < length2 + 1; j++) {
        if (char1[i - 1] == char2[j - 1]) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[length1][length2];
  }
}
