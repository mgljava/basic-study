package com.github.mgljava.basicstudy.leetcode.easy;

import com.github.mgljava.basicstudy.leetcode.TreeNode;

public class MinimumAbsoluteDifferenceInBst530 {

  public static void main(String[] args) {
    /*TreeNode treeNode = TreeUtils.getTreeNode();
    int minimumDifference = new MinimumAbsoluteDifferenceInBst530().getMinimumDifference(treeNode);
    System.out.println(minimumDifference);*/
    System.out.println(9 & 3); // 3
  }

  int pre;
  int ans;

  public int getMinimumDifference(TreeNode root) {
    ans = Integer.MAX_VALUE;
    pre = -1;
    dfs(root);
    return ans;
  }

  // 中序遍历，获得递增的数组，然后相邻的两个数相减
  private void dfs(TreeNode root) {
    if (root != null) {
      dfs(root.left);
      if (pre == -1) {
        pre = root.val;
      } else {
        ans = Math.min(root.val - pre, ans);
        pre = root.val;
      }
      dfs(root.right);
    }
  }
}
