package com.github.mgljava.basicstudy.leetcode.middle;

import com.github.mgljava.basicstudy.leetcode.ListNode;
import java.util.HashMap;
import java.util.Map;

// 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
public class ReverseLinkedList92 {

  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode res = new ListNode(-1);
    while (head != null) {
      ListNode p = head.next;
      head.next = res.next;
      res.next = head;
      head = p;
    }
    return null;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    ListNode kthFromEnd = new ReverseLinkedList92().getKthFromEnd3(head, 2);
    while (kthFromEnd != null) {
      System.out.println(kthFromEnd.val);
      kthFromEnd = kthFromEnd.next;
    }
  }

  // 基于map实现
  public ListNode getKthFromEnd(ListNode head, int k) {
    int i = 1;
    int count = 1;
    Map<Integer, ListNode> map = new HashMap<>();
    while (head != null) {
      map.put(i++, head);
      head = head.next;
      count++;
    }
    return map.get(count - k);
  }

  // 基于快慢指针
  public ListNode getKthFromEnd2(ListNode head, int k) {
    ListNode fast = head;
    ListNode slow = head;
    for (int i = 0; i < k; i++) {
      fast = fast.next;
    }
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }

  // 基于快慢指针
  public ListNode getKthFromEnd3(ListNode head, int k) {
    ListNode fast = head;
    ListNode slow = head;
    int t = 1;
    while (fast != null) {
      if (t > k) {
        slow = slow.next;
      }
      fast = fast.next;
      t++;
    }
    return slow;
  }
}
