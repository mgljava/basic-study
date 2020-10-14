package com.github.mgljava.basicstudy.leetcode.easy;

import com.github.mgljava.basicstudy.leetcode.ListNode;

public class MergeTwoLists {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(3);
    ListNode l2 = new ListNode(2);
    l2.next = new ListNode(4);
    ListNode listNode = new MergeTwoLists().mergeTwoLists(l1, l2);
    while (listNode != null) {
      System.out.println("value: " + listNode.val);
      listNode = listNode.next;
    }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    if (l1.val <= l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }
}
