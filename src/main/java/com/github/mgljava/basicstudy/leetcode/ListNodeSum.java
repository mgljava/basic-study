package com.github.mgljava.basicstudy.leetcode;

public class ListNodeSum {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);
    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);
    ListNode r = new ListNodeSum().addTwoNumbers(l1, l2);
    while (r != null) {
      System.out.println(r.val);
      r = r.next;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    StringBuilder s1 = new StringBuilder();
    ListNode head = l1;
    while (head != null) {
      s1.append(head.val);
      head = head.next;
    }

    StringBuilder s2 = new StringBuilder();
    ListNode head2 = l2;
    while (head2 != null) {
      s2.append(head2.val);
      head2 = head2.next;
    }
    int ss1 = Integer.parseInt(s1.reverse().toString());
    int ss2 = Integer.parseInt(s2.reverse().toString());
    int sum = ss1 + ss2;
    String resultString = new StringBuilder(sum + "").reverse().toString();
    ListNode node1 = new ListNode(Integer.parseInt(resultString.substring(0,1)));
    for (int i = 1; i < resultString.length(); i++) {
      node1 = new ListNode(Integer.parseInt(resultString.substring(i, i + 1)));
    }
    return node1;
  }
}

class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    this.val = x;
  }
}
