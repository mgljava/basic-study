package com.github.mgljava.basicstudy.leetcode.middle;

import com.github.mgljava.basicstudy.leetcode.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// 515 在每个树行中找最大值
public class FindLargestValueInEachTreeRow515 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(22);
    TreeNode left = new TreeNode(33);
    left.left = new TreeNode(66);
    left.right = new TreeNode(77);
    root.left = left;
    TreeNode right = new TreeNode(44);
    right.left = new TreeNode(9);
    right.right = new TreeNode(10);
    root.right = right;
    List<Integer> list = new FindLargestValueInEachTreeRow515().largestValues(root);
    System.out.println(list);
  }

  // 利用广度优先搜索来实现
  public List<Integer> largestValues(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> ans = new ArrayList<>();
    ArrayDeque<TreeNode> deque = new ArrayDeque<>();
    deque.add(root);
    while (!deque.isEmpty()) {
      int size = deque.size();
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < size; i++) {
        TreeNode treeNode = deque.remove();
        max = Math.max(max, treeNode.val);
        if (treeNode.left != null) {
          deque.add(treeNode.left);
        }
        if (treeNode.right != null) {
          deque.add(treeNode.right);
        }
      }
      ans.add(max);
    }
    return ans;
  }
}
