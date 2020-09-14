package com.github.mgljava.basicstudy.leetcode;

import java.util.ArrayList;
import java.util.List;

// 二叉树遍历
public class TreeNodeTest {

  public static void main(String[] args) {
    TreeNode rootNode = new TreeNode(6);
    TreeNode left2 = new TreeNode(2);
    TreeNode r2 = new TreeNode(8);
    rootNode.left = left2;
    rootNode.right = r2;

    r2.right = new TreeNode(9);

    TreeNode left3 = new TreeNode(0);
    left3.right = new TreeNode(1);
    TreeNode right3 = new TreeNode(4);
    right3.right = new TreeNode(5);
    left2.left = left3;
    left2.right = right3;
    new TreeNodeTest().inorderTraversal(rootNode);
  }

  // 前序遍历
  public void preOrderRecursion(TreeNode node) {
    if (null == node) {
      return;
    }
    visit(node);
    preOrderRecursion(node.left);
    preOrderRecursion(node.right);
  }

  // 中序遍历
  public void midOrderRecursion(TreeNode root) {
    if (null == root) {
      return;
    }
    midOrderRecursion(root.left);
    visit(root);
    midOrderRecursion(root.right);
  }

  // 后序遍历
  public void postOrderNonCur(TreeNode node) {
    if (null == node) {
      return;
    }
    postOrderNonCur(node.left);
    postOrderNonCur(node.right);
    visit(node);
  }

  // 结果输出
  public void visit(TreeNode node) {
    System.out.print(node.val + " ");
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    midOrderRecursion2(res, root);
    return res;
  }
  public static void midOrderRecursion2(List<Integer> res, TreeNode root) {
    if (null == root) {
      return;
    }
    midOrderRecursion2(res, root.left);
    res.add(root.val);
    midOrderRecursion2(res, root.right);
  }

}
