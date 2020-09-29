package com.github.mgljava.basicstudy.leetcode.easy;

import java.util.Arrays;

// 455 分发饼干
public class AssignCookies455 {

  public static void main(String[] args) {
    int contentChildren = new AssignCookies455().findContentChildren(new int[] {1, 2}, new int[] {1, 2, 3});
    System.out.println(contentChildren);
  }

  public int findContentChildren(int[] g, int[] s) {
    if (g == null || s == null) {
      return 0;
    }
    Arrays.sort(g);
    Arrays.sort(s);
    int gi = 0;
    int si = 0;
    while (gi < g.length && si < s.length) {
      if (g[gi] <= s[si]) {
        gi++;
      }
      si++;
    }
    return gi;
  }
}
