package com.github.mgljava.basicstudy.leetcode.middle;

import com.github.mgljava.basicstudy.leetcode.ListNode;
import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII142 {

  public ListNode detectCycle(ListNode head) {
    if (head == null) {
      return null;
    }
    Set<ListNode> set = new HashSet<>();
    while (head != null) {
      if (set.contains(head)) {
        return head;
      } else {
        set.add(head);
      }
      head = head.next;
    }
    return null;
  }
}
