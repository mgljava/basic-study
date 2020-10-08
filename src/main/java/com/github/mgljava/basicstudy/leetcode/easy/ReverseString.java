package com.github.mgljava.basicstudy.leetcode.easy;

public class ReverseString {

  public static void main(String[] args) {
    char[] chars = {'h', 'e', 'l','p', 'l', 'o'};
    new ReverseString().reverseString(chars);
    System.out.println(chars);
  }
  public void reverseString(char[] s) {
    int low = 0;
    int hi = s.length - 1;
    while (low <= hi) {
      char temp = s[low];
      s[low] = s[hi];
      s[hi] = temp;
      low++;
      hi--;
    }
  }
}
