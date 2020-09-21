package com.github.mgljava.basicstudy.leetcode.middle;

import com.github.mgljava.basicstudy.leetcode.TreeNode;

// 给定一个二叉树，判断其是否是一个有效的二叉搜索树
public class ValidateBinarySearchTree98 {

  public boolean isValidBST(TreeNode root) {
    return helper(root, null, null);
  }

  // 依次递归遍历所有子树是不是合法的二叉搜索树
  public boolean helper(TreeNode root, Integer lower, Integer upper) {
    if (root == null) {
      return true;
    }
    int val = root.val;
    if (lower != null && val <= lower) {
      return false;
    }
    if (upper != null && val >= upper) {
      return false;
    }
    if (!helper(root.left, lower, val)) {
      return false;
    }
    return helper(root.right, val, upper);
  }
}
