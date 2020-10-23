package com.zhang.interview.code.leetcode;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: TwoChainPlus
 * @Author: zxb
 * @Date: 2020/9/26 18:07
 * @Description: leetcode2 两数相加 中等
 * 描述：给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，
 * 并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 解题思路：
 */
public class TwoChainPlus {

  /**
   * 节点
   */
  public static class Node {

    int val;
    Node next;

    public Node(int val) {
      this.val = val;
    }

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder(val);
      Node node = next;
      while (node != null) {
        builder.append("->").append(node.val);
        node = node.next;
      }
      return builder.toString();
    }
  }

  public static void main(String[] args) {
    Node result = new Node(0);
    Node n = genNode(2, 4, 3);
    Node m = genNode(5, 6, 4);
    int sum = 0;
    int more = 0;
    Node temp = result;
    while (n != null || m != null || more > 0) {
      sum = (n == null ? 0 : n.val) + (m == null ? 0 : m.val) + more;
      more = sum / 10;
      sum %= 10;
      Node node = new Node(sum);
      temp.next = node;
      temp = node;
      n = n == null ? null : n.next;
      m = m == null ? null : m.next;
    }
    System.out.println(result);
  }

  /**
   * 构造链表
   *
   * @param nums 数组
   * @return 链表
   */
  private static Node genNode(int... nums) {
    if (nums == null || nums.length == 0) {
      throw new IllegalArgumentException("参数不可为空");
    }
    Node node = null, temp = null;
    for (int n : nums) {
      if (node == null) {
        node = new Node(n);
        temp = node;
      } else {
        temp.next = new Node(n);
        temp = temp.next;
      }
    }
    // 释放引用
    temp = null;
    return node;
  }
}
