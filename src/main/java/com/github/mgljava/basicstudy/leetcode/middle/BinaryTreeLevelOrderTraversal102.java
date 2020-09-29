package com.github.mgljava.basicstudy.leetcode.middle;

import com.github.mgljava.basicstudy.leetcode.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal102 {

  /**
   *      22
   *  33      44
   * 66 77   9  10
   *
   * @param args
   */
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
    List<List<Integer>> lists = new BinaryTreeLevelOrderTraversal102().levelOrder(root);
    System.out.println(lists);
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<List<Integer>> ans = new ArrayList<>();
    ArrayDeque<TreeNode> deque = new ArrayDeque<>();
    deque.add(root);
    while (!deque.isEmpty()) {
      List<Integer> res = new ArrayList<>();
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        TreeNode treeNode = deque.remove();
        res.add(treeNode.val);
        if (treeNode.left != null) {
          deque.add(treeNode.left);
        }
        if (treeNode.right != null) {
          deque.add(treeNode.right);
        }
      }
      ans.add(res);
    }
    return ans;
  }
}
