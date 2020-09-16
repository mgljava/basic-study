package com.github.mgljava.basicstudy.leetcode.easy;

import com.github.mgljava.basicstudy.leetcode.TreeNode;

public class InvertBinaryTree {

  public static TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = root.right;
    TreeNode right = root.left;
    invertTree(left);
    invertTree(right);
    return root;
  }
}
