package com.github.mgljava.basicstudy.leetcode.easy;

import com.github.mgljava.basicstudy.leetcode.ListNode;

public class MiddleLinkedList876 {

  public static void main(String[] args) {
    MiddleLinkedList876 middleLinkedList876 = new MiddleLinkedList876();
    ListNode root = new ListNode(1);
    root.next = new ListNode(2);
    root.next.next = new ListNode(3);
    root.next.next.next = new ListNode(4);
    root.next.next.next.next = new ListNode(5);
    root.next.next.next.next.next = new ListNode(6);
    ListNode listNode = middleLinkedList876.middleNode(root);
    while (listNode != null) {
      System.out.println("val : " + listNode.val);
      listNode = listNode.next;
    }
  }

  public ListNode middleNode(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}
