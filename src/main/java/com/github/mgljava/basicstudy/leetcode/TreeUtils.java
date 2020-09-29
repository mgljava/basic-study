package com.github.mgljava.basicstudy.leetcode;

public class TreeUtils {

  public static void printTree(TreeNode treeNode) {
    if (treeNode != null) {
      System.out.println(treeNode.val);
      printTree(treeNode.left);
      printTree(treeNode.right);
    }
  }

  public static TreeNode getTreeNode() {
    TreeNode root = new TreeNode(22);
    TreeNode left = new TreeNode(33);
    left.left = new TreeNode(66);
    left.right = new TreeNode(77);
    root.left = left;
    TreeNode right = new TreeNode(44);
    right.left = new TreeNode(9);
    right.right = new TreeNode(10);
    root.right = right;
    return root;
  }
}
