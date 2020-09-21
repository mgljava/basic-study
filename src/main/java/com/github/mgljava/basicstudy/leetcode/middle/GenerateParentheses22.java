package com.github.mgljava.basicstudy.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

// 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
public class GenerateParentheses22 {

  public static void main(String[] args) {
    List<String> strings = new GenerateParentheses22().generateParenthesis(6);
    System.out.println(strings);
  }

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    recur(0, 0, n, "", result);
    return result;
  }

  private void recur(int left, int right, int n, String s, List<String> result) {
    // terminal
    if (left == n && right == n) {
      result.add(s);
      return;
    }
    if (left < n) {
      recur(left + 1, right, n, s + "(", result);
    }
    if (left > right) {
      recur(left, right + 1, n, s + ")", result);
    }
  }
}
