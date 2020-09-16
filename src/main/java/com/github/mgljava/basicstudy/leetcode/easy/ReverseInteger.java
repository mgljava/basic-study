package com.github.mgljava.basicstudy.leetcode.easy;

public class ReverseInteger {

  public static void main(String[] args) {
    int reverse = new ReverseInteger().reverse(1534236469);
    System.out.println(reverse);
  }
  public int reverse(int x) {
    try {
      String value = String.valueOf(x);
      if (value.charAt(0) == '-') {
        return -Integer.parseInt(new StringBuffer(value.substring(1)).reverse().toString());
      } else {
        return Integer.parseInt(new StringBuffer(value).reverse().toString());
      }
    } catch (Exception e) {
      return 0;
    }
  }
}
