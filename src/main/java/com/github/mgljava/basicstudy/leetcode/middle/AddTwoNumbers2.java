package com.github.mgljava.basicstudy.leetcode.middle;

import com.github.mgljava.basicstudy.leetcode.ListNode;

// 给出两个 非空 的链表用来表示两个非负的整数。
// 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
public class AddTwoNumbers2 {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    ListNode l2 = new ListNode(3);
    ListNode listNode = new AddTwoNumbers2().addTwoNumbers(l1, l2);
    while (listNode != null) {
      System.out.println("value : " + listNode.val);
      listNode = listNode.next;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // 返回的Node
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1;
    ListNode q = l2;
    // 当前指针
    ListNode curr = dummyHead;
    int carry = 0; // 进位标记
    while (p != null || q != null) {
      int pv = (p != null) ? p.val : 0;
      int qv = (q != null) ? q.val : 0;
      int sum = carry + pv + qv;
      carry = sum / 10;
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
      if (p != null) {
        p = p.next;
      }
      if (q != null) {
        q = q.next;
      }
    }
    if (carry > 0) {
      curr.next = new ListNode(carry);
    }
    return dummyHead.next;
  }

  public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode res = new ListNode(0);
    ListNode head = res;
    ListNode p = l1;
    ListNode q = l2;
    int carry = 0;
    while (p != null || q != null) {
      int x = (p != null) ? p.val : 0;
      int y = (q != null) ? q.val : 0;
      int sum = x + y + carry;
      carry = sum / 10;
      head.next = new ListNode(sum % 10);
      head = head.next;
      if (p != null) {
        p = p.next;
      }
      if (q != null) {
        q = q.next;
      }
    }
    if (carry > 0) {
      head.next = new ListNode(carry);
    }
    return res.next;
  }

  /*
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) {
      return null;
    }
    StringBuilder stringBuilder = new StringBuilder();
    StringBuilder stringBuilder2 = new StringBuilder();
    while (l1 != null) {
      stringBuilder.append(l1.val);
      l1 = l1.next;
    }
    int s1 = Integer.parseInt(stringBuilder.reverse().toString());

    while (l2 != null) {
      stringBuilder2.append(l2.val);
      l2 = l2.next;
    }
    int s2 = Integer.parseInt(stringBuilder2.reverse().toString());
    int sum = s1 + s2;
    String value = sum + "";
    ListNode res = new ListNode(-1);
    ListNode head = res;
    for (int i = value.length() - 1; i >= 0; i--) {
      head.next = new ListNode(value.charAt(i) - 48);
      head = head.next;
    }
    return res.next;
  }
*/
  private static ListNode generate(String value) {
    ListNode res = new ListNode(-1);
    ListNode head = res;
    for (int i = 0; i < value.length(); i++) {
      head.next = new ListNode(value.charAt(i));
      head = head.next;
    }
    return res.next;
  }
}
