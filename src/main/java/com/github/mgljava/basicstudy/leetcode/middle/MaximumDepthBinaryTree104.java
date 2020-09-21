package com.github.mgljava.basicstudy.leetcode.middle;

import com.github.mgljava.basicstudy.leetcode.TreeNode;

public class MaximumDepthBinaryTree104 {

  public static void main(String[] args) {
    TreeNode node = new TreeNode(5);
    node.left = new TreeNode(9);
    TreeNode right = new TreeNode(20);
    right.left = new TreeNode(3);
    right.right = new TreeNode(7);
    node.right = right;
    int i = new MaximumDepthBinaryTree104().maxDepth(node);
    System.out.println(i);
  }

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int left = maxDepth(root.left);
      int right = maxDepth(root.right);
      return Math.max(left, right) + 1;
    }
  }
}
