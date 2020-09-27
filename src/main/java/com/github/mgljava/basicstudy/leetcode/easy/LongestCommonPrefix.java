package com.github.mgljava.basicstudy.leetcode.easy;

public class LongestCommonPrefix {

  public static void main(String[] args) {
    String s = new LongestCommonPrefix().longestCommonPrefix(new String[] {"flower","flow","flight"});
    System.out.println(s);
  }

  // 横向扫描

  // 纵向扫描: 通过与第一个元素进行比较获取到最长公共前缀
  public String longestCommonPrefix(String[] strs) {
    // 不满足条件，直接返回
    if (strs == null || strs.length == 0) {
      return "";
    }

    // 获取第一个字符的长度
    String first = strs[0];
    int count = strs.length;
    // 遍历第一个字符串
    for (int i = 0; i < first.length(); i++) {
      // 获取每一个字符
      char c = first.charAt(i);
      // 遍历后续的字符串数组
      for (int j = 1; j < count; j++) {
        // 如果取到的字符不等于c或者已经到了第一个字符的最长长度，那么进行截取返回
        if (i == strs[j].length() || strs[j].charAt(i) != c) {
          return first.substring(0, i);
        }
      }
    }
    // 返回第一个字符
    return strs[0];
  }
}
