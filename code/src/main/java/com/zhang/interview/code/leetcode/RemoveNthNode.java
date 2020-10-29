package com.zhang.interview.code.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: RemoveNthNode
 * @Author: zxb
 * @Date: 2020/10/29 14:26
 * @Description: leetcode19 删除链表的倒数第N个节点 中等
 * 描述：给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 说明：
 * 给定的n保证是有效的。
 * <p>
 * 进阶：
 * 你能尝试使用一趟扫描实现吗
 */
public class RemoveNthNode {

  public static class ListNode {

    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
      this.val = val;
    }

    public ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder(val + "");
      while (next != null) {
        sb.append("->").append(next.val);
        next = next.next;
      }
      return sb.toString();
    }
  }

  public static void main(String[] args) {
    ListNode tail = new ListNode();
    ListNode head = tail;
    for (int i = 1; i <= 5; i++) {
      tail.next = new ListNode(i);
      tail = tail.next;
    }
    ListNode node = new RemoveNthNode().removeNthFromEnd(head.next, 2);
    System.out.println("结果：" + node);
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    ListNode first = head;
    ListNode second = dummy;
    // 使first指针域second指针相差n个
    for (int i = 0; i < n; i++) {
      first = first.next;
    }
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
  }

  public ListNode removeNthFromEnd2(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    Deque<ListNode> stack = new LinkedList<>();
    ListNode cur = dummy;
    while (cur != null) {
      stack.push(cur);
      cur = cur.next;
    }
    for (int i = 0; i < n; i++) {
      stack.pop();
    }
    ListNode prev = stack.peek();
    prev.next = prev.next.next;
    return dummy.next;
  }
}
