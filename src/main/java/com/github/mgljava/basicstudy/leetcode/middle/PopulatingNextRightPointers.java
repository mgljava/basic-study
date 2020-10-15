package com.github.mgljava.basicstudy.leetcode.middle;

import com.github.mgljava.basicstudy.leetcode.Node;
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers {

  public Node connect(Node root) {
    if (root == null) {
      return null;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int levelCount = queue.size();
      Node pre = null;
      for (int i = 0; i < levelCount; i++) {
        Node node = queue.poll();
        if (pre != null) {
          pre.next = node;
        }
        pre = node;
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }
    return root;
  }
}
