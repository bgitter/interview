package com.zhang.interview.code.leetcode;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ReverseNodesInKGroup
 * @Author: zxb
 * @Date: 2020/10/30 16:23
 * @Description: leetcode25 K个一组反转链表 困难
 * 描述：给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明：
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class ReverseNodesInKGroup {

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
    ListNode res = new ReverseNodesInKGroup().reverseKGroup(head.next, 2);
    System.out.println("结果：" + res);
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode hair = new ListNode(0);
    hair.next = head;
    ListNode prev = hair;

    while (head != null) {
      ListNode tail = prev;
      // 查看剩余部分长度是否大于等于k
      for (int i = 0; i < k; i++) {
        tail = tail.next;
        if (tail == null) {
          return hair.next;
        }
      }

      ListNode next = tail.next;
      // 反转
      ListNode[] reverse = reverse(head, tail);
      head = reverse[0];
      tail = reverse[1];
      // 把子链表重新按回原链表
      prev.next = head;
      tail.next = next;
      prev = tail;
      head = tail.next;
    }
    return hair.next;
  }

  /**
   * 子链表反转
   *
   * @param head 头节点
   * @param tail 尾节点
   * @return 反转结果
   */
  public ListNode[] reverse(ListNode head, ListNode tail) {
    ListNode prev = tail.next;
    ListNode p = head;
    while (prev != tail) {
      ListNode next = p.next;
      p.next = prev;
      prev = p;
      p = next;
    }
    return new ListNode[]{tail, head};
  }
}
