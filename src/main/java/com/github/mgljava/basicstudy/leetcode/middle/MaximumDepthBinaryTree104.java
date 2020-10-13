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


  /**
   * 递归实现，递归三部曲
   * 1. 找到终止条件
   * 2. 当前层做什么逻辑
   * 3. 给上一层返回什么
   *
   * 该题求树的最大深度，那么就转为一颗最简单的树，求左子树的深度和右子树的深度 max(l,r)+1
   * @param root
   * @return
   */
  public int maxDepth2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftLength = maxDepth2(root.left);
    int rightLength = maxDepth2(root.right);
    // 当前层的最大深度加 1
    return Math.max(leftLength, rightLength) + 1;
  }















}
