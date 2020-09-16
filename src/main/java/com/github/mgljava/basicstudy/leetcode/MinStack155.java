package com.github.mgljava.basicstudy.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小栈
 */
public class MinStack155 {

  private final Deque<Integer> stack = new LinkedList<>();
  private final Deque<Integer> minStack = new LinkedList<>();

  public MinStack155() {
    minStack.push(Integer.MAX_VALUE);
  }

  public void push(int x) {
    stack.push(x);
    minStack.push(Math.min(minStack.peek(), x));
  }

  public void pop() {
    stack.pop();
    minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
