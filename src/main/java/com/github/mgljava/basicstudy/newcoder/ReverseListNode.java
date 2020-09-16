package com.github.mgljava.basicstudy.newcoder;

import com.github.mgljava.basicstudy.leetcode.ListNode;
import java.util.Stack;

public class ReverseListNode {

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(3);
    ListNode listNode = new ReverseListNode().ReverseList2(head);
    System.out.println(listNode.val);
    System.out.println(listNode.next.val);
  }

  // 使用双链表解决，头插法
  public ListNode ReverseList(ListNode head) {
    ListNode res = new ListNode(-1);
    while (head != null) {
      // 下一个节点，用于循环
      ListNode tmpNode = head.next;
      // 每次访问的原链表节点都会成为新链表的头结点，
      // 其实就是把新链表挂到访问的原链表节点的后面就行了
      head.next = res.next;
      // 更新新链表
      res.next = head;
      // 重新赋值  继续循环
      head = tmpNode;
    }
    return res.next;
  }

  // 使用栈解决，耗时很久
  public ListNode ReverseList2(ListNode head) {
    Stack<ListNode> stack = new Stack<>();
    while (head != null) {
      stack.push(head);
      head = head.next;
    }
    if (stack.isEmpty()) {
      return null;
    }
    // 头结点
    ListNode node = stack.pop();
    ListNode dummy = node;
    while (!stack.isEmpty()) {
      node.next = stack.pop();
      node = node.next;
    }
    node.next = null;
    return dummy;
  }

  // 递归
  public ListNode ReverseList3(ListNode head) {
    // 终止条件
    if (head == null || head.next == null) {
      return head;
    }
    ListNode next = head.next;
    ListNode reverse = ReverseList3(head.next);
    next.next = head;
    //这里head相当于变成了尾结点，尾结点都是为空的，
    //否则会构成环
    head.next = null;
    return reverse;
  }
}
