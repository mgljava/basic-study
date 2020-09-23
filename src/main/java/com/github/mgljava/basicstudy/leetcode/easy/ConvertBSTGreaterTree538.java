package com.github.mgljava.basicstudy.leetcode.easy;

import com.github.mgljava.basicstudy.leetcode.TreeNode;

// 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
// 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
public class ConvertBSTGreaterTree538 {

  private int sum = 0;

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(13);
    ConvertBSTGreaterTree538 tree538 = new ConvertBSTGreaterTree538();
    TreeNode treeNode = tree538.convertBST(root);
    tree538.print(treeNode);
  }

  public void print(TreeNode root) {
    if (root != null) {
      print(root.left);
      System.out.println("node value: " + root.val);
      print(root.right);
    }
  }

  // 反向中序遍历
  public TreeNode convertBST(TreeNode root) {
    if (root != null) {
      convertBST(root.right);
      sum += root.val;
      root.val = sum;
      convertBST(root.left);
    }
    return root;
  }
}
