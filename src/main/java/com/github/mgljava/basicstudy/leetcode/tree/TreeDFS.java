package com.github.mgljava.basicstudy.leetcode.tree;

import com.github.mgljava.basicstudy.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class TreeDFS {

  public static void main(String[] args) {
    ArrayList<TreeNode> nodes = new ArrayList<>();
    TreeNode root = new TreeNode(22);
    root.left = new TreeNode(33);
    root.right = new TreeNode(21);
    new TreeDFS().dfs(root, nodes);
    System.out.println(nodes);
  }

  // 遍历一颗树
  public void dfs(TreeNode root, List<TreeNode> nodes) {
    if (root != null) {
      nodes.add(root);
      dfs(root.left, nodes);
      dfs(root.right, nodes);
    }
  }
}
