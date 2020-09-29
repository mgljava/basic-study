package com.github.mgljava.basicstudy.leetcode.easy;

public class ImplementStrstr {

  public static void main(String[] args) {
    int i = new ImplementStrstr().strStr("aaaacdacd", "acd");
    System.out.println(i);
  }

  public int strStr(String haystack, String needle) {
    if (haystack.trim().equals("") && needle.trim().equals("")) {
      return 0;
    }
    if (needle.trim().equals("")) {
      return 0;
    }
    if (haystack.trim().equals("")) {
      return -1;
    }
    if (!haystack.contains(needle)) {
      return -1;
    }
    for (int i = 0; i < haystack.length(); i++) {
      if (haystack.charAt(i) == needle.charAt(0) && haystack.startsWith(needle, i)) {
        return i;
      }
    }
    return -1;
  }
}
