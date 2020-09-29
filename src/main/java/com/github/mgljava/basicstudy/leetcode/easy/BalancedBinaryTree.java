package com.github.mgljava.basicstudy.leetcode.easy;

import com.github.mgljava.basicstudy.leetcode.TreeNode;
import com.github.mgljava.basicstudy.leetcode.TreeUtils;

public class BalancedBinaryTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(22);
    root.left = left;
    left.left = new TreeNode(33);
    left.left.left = new TreeNode(44);
    BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
    boolean balanced = balancedBinaryTree.isBalanced(TreeUtils.getTreeNode());
    System.out.println(balanced);
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    } else {
      return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
  }

  public int height(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      return Math.max(height(root.left), height(root.right)) + 1;
    }
  }
}
