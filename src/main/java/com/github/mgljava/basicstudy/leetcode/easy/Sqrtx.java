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
    int left = 0;
    int right = x;
    int ans = -1;
    while (left <= right) {
      int mid = left + (right - 1) / 2;
      if (mid * mid <= x) {
        ans = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return ans;
  }
}
