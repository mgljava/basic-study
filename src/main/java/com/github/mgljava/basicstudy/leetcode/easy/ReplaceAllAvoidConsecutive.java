package com.github.mgljava.basicstudy.leetcode.easy;


// 替换掉所有的问号
public class ReplaceAllAvoidConsecutive {

  public static void main(String[] args) {
    String s = new ReplaceAllAvoidConsecutive().modifyString("j?qg??b");
    System.out.println(s);
  }

  public String modifyString(String s) {
    char[] chars = s.toCharArray();

    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '?') {
        char left = (i == 0 ? '$' : chars[i - 1]);
        char right = (i == s.length() - 1 || s.charAt(i + 1) == '?') ? '$' : s.charAt(i + 1);
        if (left != 'a' && right != 'a') {
          chars[i] = 'a';
        } else if (left != 'b' && right != 'b') {
          chars[i] = 'b';
        } else {
          chars[i] = 'c';
        }
      }
    }
    return new String(chars);
  }
}
