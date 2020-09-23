package com.github.mgljava.basicstudy.leetcode.easy;

import com.github.mgljava.basicstudy.leetcode.TreeNode;
import com.github.mgljava.basicstudy.leetcode.TreeUtils;

public class MergeTwoBinaryTrees {

  public static void main(String[] args) {
    TreeNode treeNode = new MergeTwoBinaryTrees().mergeTrees(new TreeNode(2), new TreeNode(3));
    TreeUtils.printTree(treeNode);
  }

  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }
    TreeNode treeNode = new TreeNode(t1.val + t2.val);
    treeNode.left = mergeTrees(t1.left, t2.left);
    treeNode.right = mergeTrees(t1.right, t2.right);
    return treeNode;
  }

  public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }
    t1.val = t1.val + t2.val;
    t1.left = mergeTrees2(t1.left, t1.right);
    t1.right = mergeTrees2(t1.right, t2.right);
    return t1;
  }
}
