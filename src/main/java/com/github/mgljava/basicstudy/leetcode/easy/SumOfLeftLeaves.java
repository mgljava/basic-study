package com.github.mgljava.basicstudy.leetcode.easy;

import com.github.mgljava.basicstudy.leetcode.TreeNode;

public class SumOfLeftLeaves {

  public static void main(String[] args) {
    TreeNode treeNode = new TreeNode(3);
    treeNode.left = new TreeNode(9);
    TreeNode right = new TreeNode(20);
    right.left = new TreeNode(15);
    right.right = new TreeNode(7);
    treeNode.right = right;
    int i = new SumOfLeftLeaves().sumOfLeftLeaves(treeNode);
    System.out.println(i);
  }

  public int sumOfLeftLeaves(TreeNode root) {
    Integer integer = 0;
    return func(root, integer);
  }

  public static int func(TreeNode root, Integer value) {
    while (root == null) {
      return value;
    }
    value = root.val + value;
    return func(root.left, value);
  }
}
