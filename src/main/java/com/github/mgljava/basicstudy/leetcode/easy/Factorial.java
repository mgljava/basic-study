package com.github.mgljava.basicstudy.leetcode.easy;

// 用递归解决阶乘问题
public class Factorial {

  public static void main(String[] args) {
    int result = new Factorial().recur(5);
    System.out.println(result);
  }
  public int recur(int n) {
    if (n == 1) {
      return 1;
    }
    return n * recur(n - 1);
  }
}
