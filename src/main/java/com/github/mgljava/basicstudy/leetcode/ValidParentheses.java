package com.github.mgljava.basicstudy.leetcode;

import java.util.Stack;

/**
 * 有效的括号
 * <p></p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 */

public class ValidParentheses {

  public static void main(String[] args) {
    System.out.println(new ValidParentheses().isValid("([])"));
  }

  public boolean isValid(String s) {
    if (s.length() % 2 != 0) {
      return false;
    }
    Stack<Character> stack = new Stack();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(')');
      } else if (c == '{') {
        stack.push('}');
      } else if (c == '[') {
        stack.push(']');
      } else if (stack.isEmpty() || c != stack.pop()) {
        return false;
      }
    }
    return stack.isEmpty();
  }
}
