package com.github.mgljava.basicstudy.effective_java;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 7. 消除过期引用
 */
public class ExpireReference {

  private Object[] elements;
  private int size = 0;
  private static final int DEFAULT_INITIAL_CAPACITY = 10;

  public ExpireReference() {
    elements = new Object[DEFAULT_INITIAL_CAPACITY];
  }

  public void push(Object e) {
    ensureCapacity();
    elements[size++] = e;
  }

  /*
  在元素被弹出后，栈的内部会维护着对这些对象的"过期引用"，所谓过期引用就是不会再被解除的引用

  正确的做法是在弹出元素后，手动置为null：elements[size] = null;
   */
  public Object pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    elements[size] = null;
    return elements[--size];
  }

  private void ensureCapacity() {
    if (elements.length == size) {
      elements = Arrays.copyOf(elements, size << 1);
    }
  }
}
