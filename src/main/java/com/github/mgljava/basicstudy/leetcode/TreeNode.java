package com.github.mgljava.basicstudy.leetcode;

public class TreeNode {

  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    val = x;
  }

  @Override
  public String toString() {
    return "val: " + val;
  }
}
