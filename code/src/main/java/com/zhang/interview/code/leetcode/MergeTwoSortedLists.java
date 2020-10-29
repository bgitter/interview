package com.zhang.interview.code.leetcode;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: MergeTwoSortedLists
 * @Author: zxb
 * @Date: 2020/10/29 17:40
 * @Description: leetcode21 合并两个有序链表 简单
 * 描述：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

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
    ListNode tail1 = new ListNode();
    ListNode tail2 = new ListNode();
    ListNode l1 = tail1;
    ListNode l2 = tail2;
    for (int i = 0; i < 5; i++) {
      tail1.next = new ListNode(i);
      tail2.next = new ListNode(i + 10);
      tail1 = tail1.next;
      tail2 = tail2.next;
    }
    ListNode res = new MergeTwoSortedLists().mergeTwoLists2(l1.next, l2.next);
    System.out.println("结果：" + res);
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    } else if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }

  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    ListNode prehead = new ListNode(-1);
    ListNode pre = prehead;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        pre.next = l1;
        l1 = l1.next;
      } else {
        pre.next = l2;
        l2 = l2.next;
      }
      pre = pre.next;
    }
    // 合并后l1和l2最多只有一个还未被合并完，这里直接将链表末尾指向未合并完的链表即可
    pre.next = l1 != null ? l1 : l2;
    return prehead.next;
  }

}
