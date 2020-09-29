package com.github.mgljava.basicstudy.leetcode.tree;

import com.github.mgljava.basicstudy.leetcode.TreeNode;
import java.util.ArrayDeque;

public class TreeBFS {

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
    new TreeBFS().bfs(root);
  }

  public void bfs(TreeNode root) {
    ArrayDeque<TreeNode> deque = new ArrayDeque<>();
    deque.add(root);
    while (!deque.isEmpty()) {
      TreeNode remove = deque.remove();
      System.out.println("value : " + remove.val);
      if (remove.left != null) {
        deque.add(remove.left);
      }
      if (remove.right != null) {
        deque.add(remove.right);
      }
    }
  }
}
