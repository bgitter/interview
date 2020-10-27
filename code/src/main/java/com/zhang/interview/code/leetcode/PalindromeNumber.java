package com.zhang.interview.code.leetcode;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: PalindromeNumber
 * @Author: zxb
 * @Date: 2020/10/27 14:01
 * @Description: leetcode9 回文数 简单
 * 描述：判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例1:
 * 输入: 121
 * 输出: true
 * <p>
 * 示例2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class PalindromeNumber {

  public static void main(String[] args) {
    int x = 101;
    boolean flag = new PalindromeNumber().isPalindrome(x);
    System.out.println("x: " + x + " 是否为回文：" + flag);
  }

  public boolean isPalindrome(int x) {
    if (x < 0 || (x != 0 && x % 10 == 0)) {
      return false;
    }
    int res = 0;
    while (x > res) {
      res = res * 10 + x % 10;
      x /= 10;
    }
    return res == x || x == res / 10;
  }

}
