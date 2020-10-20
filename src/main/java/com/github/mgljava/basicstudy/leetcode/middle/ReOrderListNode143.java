package com.github.mgljava.basicstudy.leetcode.middle;

import com.github.mgljava.basicstudy.leetcode.ListNode;

public class ReOrderListNode143 {

  /*
   * 重排序链表.
   * 1. 找到链表的中点.
   * 2. 将后部分逆序.
   * 3. 交替插入到链表
   *
   * @param head
   */
  public void reorderList(ListNode head) {
    if (head == null) {
      return;
    }
    ListNode mid = middleNode(head);
    ListNode l1 = head;
    ListNode l2 = mid.next;
    mid.next = null;
    l2 = reverseList(l2);
    mergeList(l1, l2);
  }

  // 找到中间节点
  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  // 反转链表
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }

  // 合并链表
  public void mergeList(ListNode l1, ListNode l2) {
    ListNode l1_tmp;
    ListNode l2_tmp;
    while (l1 != null && l2 != null) {
      l1_tmp = l1.next;
      l2_tmp = l2.next;

      l1.next = l2;
      l1 = l1_tmp;

      l2.next = l1;
      l2 = l2_tmp;
    }
  }
}
