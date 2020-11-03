package com.zhang.interview.code.leetcode;

import org.apache.commons.lang3.RandomUtils;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: MergeKSortedLists
 * @Author: zxb
 * @Date: 2020/10/30 14:15
 * @Description: leetcode23 合并k个升序链表 困难
 * 描述：给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * 提示：
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
public class MergeKSortedLists {

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
    ListNode[] lists = new ListNode[3];
    for (int i = 0; i < 3; i++) {
      int r = RandomUtils.nextInt(2, 5);
      ListNode tail = new ListNode();
      ListNode head = tail;
      for (int j = 0; j < r; j++) {
        tail.next = new ListNode(j);
        tail = tail.next;
      }
      lists[i] = head.next;
    }
    ListNode res = new MergeKSortedLists().mergeKLists3(lists);
    System.out.println("结果：" + res);
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }

    ListNode current = lists[0];
    for (int i = 1; i < lists.length; i++) {
      current = mergeLists(current, lists[i]);
    }
    return current;
  }

  public ListNode mergeLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    } else if (l1.val < l2.val) {
      l1.next = mergeLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeLists(l1, l2.next);
      return l2;
    }
  }

  public ListNode mergeKLists2(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    ListNode current = lists[0];
    for (int i = 1; i < lists.length; i++) {
      current = mergeLists2(current, lists[i]);
    }
    return current;
  }

  public ListNode mergeLists2(ListNode l1, ListNode l2) {
    ListNode prevNode = new ListNode(-1);
    ListNode prev = prevNode;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        prev.next = l1;
        l1 = l1.next;
      } else {
        prev.next = l2;
        l2 = l2.next;
      }
      prev = prev.next;
    }
    prev.next = l1 != null ? l1 : l2;
    return prevNode.next;
  }

  public ListNode mergeKLists3(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }

    return merge3(lists, 0, lists.length - 1);
  }

  public ListNode merge3(ListNode[] lists, int start, int end) {
    if (start >= end) {
      return lists[start];
    }
    int mid = start + (end - start) / 2;
    ListNode l1 = merge3(lists, start, mid);
    ListNode l2 = merge3(lists, mid + 1, end);
    return mergeLists2(l1, l2);
  }
}
