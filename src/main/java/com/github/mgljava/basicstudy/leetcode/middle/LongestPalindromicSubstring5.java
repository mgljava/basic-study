package com.github.mgljava.basicstudy.leetcode.middle;

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

    int start = 0;
    int end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = expandAroundCenter(s, i, i);
      int len2 = expandAroundCenter(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  public int expandAroundCenter(String str, int start, int end) {
    while (start >= 0 && end <= str.length() && str.charAt(start) == str.charAt(end)) {
      start--;
      end++;
    }
    return end - start - 1;
  }
}
