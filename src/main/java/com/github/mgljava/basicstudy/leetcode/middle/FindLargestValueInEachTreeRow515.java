package com.github.mgljava.basicstudy.leetcode.middle;

import com.github.mgljava.basicstudy.leetcode.TreeNode;
import com.github.mgljava.basicstudy.leetcode.TreeUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// 515 在每个树行中找最大值
public class FindLargestValueInEachTreeRow515 {

  public static void main(String[] args) {
    TreeNode root = TreeUtils.getTreeNode();
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
