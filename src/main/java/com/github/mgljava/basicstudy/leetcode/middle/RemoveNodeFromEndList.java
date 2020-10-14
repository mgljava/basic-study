package com.github.mgljava.basicstudy.leetcode.middle;

import com.github.mgljava.basicstudy.leetcode.ListNode;

// 删除链表的倒数第N个节点
public class RemoveNodeFromEndList {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode fast = head;
    ListNode slow = head;
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }
    if (fast == null) {
      return head.next;
    }
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return head;
  }
}
