package com.github.mgljava.basicstudy.leetcode.middle;

import java.util.Arrays;

// 最长回文子串
public class LongestPalindromicSubstring5 {

  public static void main(String[] args) {
    String result = new LongestPalindromicSubstring5().longestPalindrome2("cbabd");
    System.out.println(result);
  }

  // 动态规划，状态转移方程：P(i,j)=P(i+1,j−1)∧(Si==Sj)
  public String longestPalindrome(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    String ans = "";
    for (int l = 0; l < n; l++) {
      for (int i = 0; i + l < n; i++) {
        int j = i + l;
        if (l == 0) {
          dp[i][j] = true;
        } else {
          boolean b = s.charAt(i) == s.charAt(j);
          if (l == 1) {
            dp[i][j] = b;
          } else {
            dp[i][j] = (b && dp[i + 1][j - 1]);
          }
        }
        if (dp[i][j] && l + 1 > ans.length()) {
          ans = s.substring(i, i + l + 1);
        }
      }
    }
    return ans;
  }

  // 中心扩展算法
  public String longestPalindrome2(String s) {
    if (s == null || s.isEmpty()) {
      return "";
    }

    int length = s.length();
    String[] dp = new String[length];
    dp[0] = s.charAt(0) + "";
    for (int i = 1; i < length; i++) {
      int lo = i;
      int hi = i;
      while (hi < length && lo >= 0 && s.charAt(lo) == s.charAt(hi)) {
        dp[i] = s.substring(lo, hi + 1);
        if (s.charAt(lo--) == s.charAt(i)) {
          lo--;
          continue;
        } else if (s.charAt(i) == s.charAt(hi++)) {
          hi++;
          continue;
        }
        lo--;
        hi++;
      }
    }
    Arrays.stream(dp).forEach(System.out::println);
    return "";
  }
}
