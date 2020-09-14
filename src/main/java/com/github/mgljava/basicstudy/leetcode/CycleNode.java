package com.github.mgljava.basicstudy.leetcode;

import java.util.HashSet;
import java.util.Set;

// 环形链表
public class CycleNode {

  public boolean hasCycle(ListNode head) {
    Set<ListNode> nodes = new HashSet<>();
    while (head != null) {
      if (nodes.contains(head)) {
        return true;
      }
      nodes.add(head);
      head = head.next;
    }
    return false;
  }
}
