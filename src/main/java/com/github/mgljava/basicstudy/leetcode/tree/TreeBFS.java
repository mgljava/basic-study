package com.github.mgljava.basicstudy.leetcode.tree;

import com.github.mgljava.basicstudy.leetcode.TreeNode;
import com.github.mgljava.basicstudy.leetcode.TreeUtils;
import java.util.ArrayDeque;

public class TreeBFS {

  public static void main(String[] args) {
    TreeNode root = TreeUtils.getTreeNode();
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
