package com.github.mgljava.basicstudy.leetcode.easy;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <br>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <br>
 * "abccccdd" -> 7
 */
public class LongestPalindrome409 {

  public static void main(String[] args) {
    int i = new LongestPalindrome409().longestPalindrome("abccccdd");
    System.out.println(i);
  }

  public int longestPalindrome(String s) {
    int[] arr = new int[128];
    for (char c : s.toCharArray()) {
      arr[c]++;
    }
    int count = 0;
    for (int i : arr) {
      // 记录奇数的个数
      count += (i % 2);
    }
    // 如果奇数为0，则组成的最大长度为字符串的长度，否则长度减去奇数个数+1，+1是因为中间的元素为回文中心
    return count == 0 ? s.length() : s.length() - count + 1;
  }
}
