package com.zhang.interview.code.leetcode;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: SwapNodesInParis
 * @Author: zxb
 * @Date: 2020/10/30 15:30
 * @Description: leetcode24 两两交换链表中的节点 中等
 * 描述：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 */
public class SwapNodesInParis {

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
    for (int i = 1; i < 10; i++) {
      tail.next = new ListNode(i);
      tail = tail.next;
    }
    ListNode res = new SwapNodesInParis().swapPairs2(head.next);
    System.out.println("结果：" + res);
  }

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    // 头节点
    ListNode next = head.next;
    head.next = swapPairs(next.next);
    next.next = head;
    return next;
  }

  public ListNode swapPairs2(ListNode head) {
    ListNode prev = new ListNode(0);
    prev.next = head;
    ListNode node = prev;
    while (node.next != null && node.next.next != null) {
      ListNode start = node.next;
      ListNode end = node.next.next;
      node.next = end;
      start.next = end.next;
      end.next = start;
      node = start;
    }
    return prev.next;
  }
}
