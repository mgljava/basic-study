package com.github.mgljava.basicstudy.leetcode;

public class TreeUtils {

  public static void printTree(TreeNode treeNode) {
    if (treeNode != null) {
      System.out.println(treeNode.val);
      printTree(treeNode.left);
      printTree(treeNode.right);
    }
  }
}
