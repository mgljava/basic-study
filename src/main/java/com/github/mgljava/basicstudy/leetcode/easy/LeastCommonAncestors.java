package com.github.mgljava.basicstudy.leetcode.easy;

import com.github.mgljava.basicstudy.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class LeastCommonAncestors {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> pValue = this.getValue(root, p);
    List<TreeNode> qValue = this.getValue(root, q);
    TreeNode ancestor = null;
    for (int i = 0; i < pValue.size() && i < qValue.size(); i++) {
      if (pValue.get(i) == qValue.get(i)) {
        ancestor = qValue.get(i);
      } else {
        break;
      }
    }
    return ancestor;
  }

  public List<TreeNode> getValue(TreeNode root, TreeNode target) {
    List<TreeNode> path = new ArrayList<>();
    TreeNode node = root;
    while (node != target) {
      path.add(node);
      if (node.val > target.val) {
        node = node.left;
      } else {
        node = node.right;
      }
    }
    path.add(node);
    return path;
  }
}
