package com.github.mgljava.basicstudy.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

  private Deque<Integer> stack = new LinkedList<>();
  private Deque<Integer> minStack = new LinkedList<>();

  public MinStack() {
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
