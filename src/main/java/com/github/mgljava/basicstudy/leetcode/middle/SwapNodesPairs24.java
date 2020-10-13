package com.github.mgljava.basicstudy.leetcode.middle;

import com.github.mgljava.basicstudy.leetcode.ListNode;

// 两两交换链表中的节点, 给定 1->2->3->4, 你应该返回 2->1->4->3
public class SwapNodesPairs24 {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode next = new ListNode(2);
    next.next = new ListNode(3);
    next.next.next = new ListNode(4);
    head.next = next;
    ListNode listNode = new SwapNodesPairs24().swapPairs(head);
    System.out.println(listNode);
  }
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode next = head.next;
    head.next = swapPairs(next.next);
    next.next = head;
    return next;
  }
}
