package com.github.mgljava.basicstudy.leetcode.middle;

import com.github.mgljava.basicstudy.leetcode.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePostorderTraversal145 {

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
    List<Integer> list = new BinaryTreePostorderTraversal145().preOrder(root);
    System.out.println(list);
  }

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    this.dfs(root, res);
    return res;
  }

  // 递归实现
  public void dfs(TreeNode root, List<Integer> res) {
    if (root != null) {
      dfs(root.left, res);
      dfs(root.right, res);
      res.add(root.val);
    }
  }

  // 非递归实现后续遍历
  public List<Integer> postorderTraversal2(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    ArrayDeque<TreeNode> stack = new ArrayDeque<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        res.add(root.val);
        stack.push(root);
        root = root.right;
      }
      TreeNode cur = stack.pop();
      root = cur.left;
    }
    Collections.reverse(res);
    return res;
  }

  // 非递归实现前序遍历
  public List<Integer> preOrder(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    ArrayDeque<TreeNode> stack = new ArrayDeque<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        res.add(root.val);
        stack.push(root);
        root = root.left;
      }
      TreeNode cur = stack.pop();
      root = cur.right;
    }
    return res;
  }
}
