package com.github.mgljava.basicstudy.leetcode.easy;

import com.github.mgljava.basicstudy.leetcode.ListNode;
import java.util.ArrayList;
import java.util.List;

// 回文链表
public class PalindromeLinkedList234 {

  public static void main(String[] args) {
    ListNode root = new ListNode(1);
    root.next = new ListNode(2);
    root.next.next = new ListNode(3);
    root.next.next.next = new ListNode(2);
    root.next.next.next.next = new ListNode(1);
    boolean palindrome = new PalindromeLinkedList234().isPalindrome(root);
    System.out.println(palindrome);
  }

  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    List<Integer> list = new ArrayList<>();
    while (head != null) {
      list.add(head.val);
      head = head.next;
    }

    int start = 0;
    int end = list.size() - 1;
    while (start < end) {
      if (!list.get(start).equals(list.get(end))) {
        return false;
      } else {
        start++;
        end--;
      }
    }
    return true;
  }
}
