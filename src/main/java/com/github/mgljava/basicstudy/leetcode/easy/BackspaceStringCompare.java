package com.github.mgljava.basicstudy.leetcode.easy;

import java.util.Stack;

// 较含退格的字符串
public class BackspaceStringCompare {

  public static void main(String[] args) {
    String back = new BackspaceStringCompare().back("a##c");
    System.out.println(back);
  }

  public boolean backspaceCompare(String S, String T) {
    return back(S).equals(back(T));
  }

  public String back(String str) {
    Stack<Character> strings = new Stack<>();
    for (char c : str.toCharArray()) {
      if (c != '#') {
        strings.push(c);
      } else if (!strings.isEmpty()) {
        strings.pop();
      }
    }
    StringBuilder stringBuilder = new StringBuilder();
    while (!strings.isEmpty()) {
      stringBuilder.append(strings.pop());
    }
    return stringBuilder.reverse().toString();
  }
}
