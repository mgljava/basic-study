package com.github.mgljava.basicstudy.lintcode.easy;

public class CompressString {

  public static void main(String[] args) {
    String result = new CompressString().compress("abbccd");
    System.out.println(result);
  }
  public String compress(String S) {
    if (S == null || S.length() == 0) {
      return "";
    }
    char[] chars = S.toCharArray();
    int cnt = 1;
    char c = chars[0];
    StringBuilder ans = new StringBuilder();
    for (int i = 1; i < chars.length; i++) {
      if (chars[i] == c) {
        cnt++;
      } else {
        ans.append(c);
        ans.append(cnt);
        c = chars[i];
        cnt = 1;
      }
    }
    ans.append(c);
    ans.append(cnt);
    return ans.toString().length() >= S.length() ? S : ans.toString();
  }
}
