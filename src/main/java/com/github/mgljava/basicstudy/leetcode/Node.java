package com.github.mgljava.basicstudy.leetcode;

public class Node {

  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {
  }

  public Node(int value) {
    val = value;
  }

  public Node(int value, Node left, Node right, Node next) {
    val = value;
    this.left = left;
    this.right = right;
    this.next = next;
  }
}
