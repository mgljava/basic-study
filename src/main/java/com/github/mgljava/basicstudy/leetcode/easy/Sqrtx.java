package com.github.mgljava.basicstudy.leetcode.easy;

public class Sqrtx {

  public static void main(String[] args) {
    int i = new Sqrtx().mySqrt(8);
    System.out.println(i);
  }

  public int mySqrt(int x) {
    if (x == 0 || x == 1) {
      return x;
    }
    int left = 1;
    int right = x;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (mid * mid > x) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return right;
  }
}
