package com.github.mgljava.basicstudy.leetcode.middle;

import com.github.mgljava.basicstudy.leetcode.TreeNode;
import com.github.mgljava.basicstudy.leetcode.TreeUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 {

  public static void main(String[] args) {
    List<Integer> list = new BinaryTreePreorderTraversal144().preorderTraversal2(TreeUtils.getTreeNode());
    System.out.println(list);
  }

  // 递归实现
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    dfs(res, root);
    return res;
  }

  public void dfs(List<Integer> res, TreeNode root) {
    if (root != null) {
      res.add(root.val);
      dfs(res, root.left);
      dfs(res, root.right);
    }
  }


  // 栈实现
  public List<Integer> preorderTraversal2(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode pop = stack.pop();
      res.add(pop.val);
      if (pop.right != null) {
        stack.push(pop.right);
      }
      if (pop.left != null) {
        stack.push(pop.left);
      }
    }
    return res;
  }
}
