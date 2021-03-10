package com.zhang.interview.code.leetcode;

/**
 * @Copyright (C), 2018-2021, 北京数知科技股份有限公司
 * @FileName: TowDivide
 * @Author: zxb
 * @Date: 2021/3/10 16:47
 * @Description: 两数相除
 * 描述：给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8，以及 truncate(-2.7335) = -2。
 * <p>
 * 示例1：
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * <p>
 * 示例2：
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 * <p>
 * 提示：
 * 1.被除数和除数均为 32 位有符号整数。
 * 2.除数不为0。
 * 3.假设我们的环境只能存储 32 位有符号整数，其数值范围是 [-2^31, (2^31) - 1]。本题中，如果除法结果溢出，则返回 (2^31) - 1。
 * <p>
 * leetcode：https://leetcode-cn.com/problems/divide-two-integers/
 */
public class TowDivide {

  public static void main(String[] args) {
    int r = divide(Integer.MIN_VALUE, -1);
    System.out.println("两数相除，商为：" + r);
  }

  public static int divide(int dividend, int divisor) {
    if (dividend == 0) {
      return 0;
    }
    if (divisor == 1) {
      return dividend;
    }
    if (divisor == -1) {
      if (dividend > Integer.MIN_VALUE) {
        // 只要不是最小的那个整数，都是直接返回相反数就好
        return -dividend;
      }
      // 是最小的那个，那就返回最大的整数（溢出）
      return Integer.MAX_VALUE;
    }
    long a = dividend;
    long b = divisor;
    int sign = 1;
    if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
      sign = -1;
    }

    // 取正数处理
    a = a > 0 ? a : -a;
    b = b > 0 ? b : -b;
    long res = div(a, b);
    if (sign > 0) {
      return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
    }
    return -(int) res;
  }

  static long div(long a, long b) {
    if (a < b) {
      return 0;
    }

    long count = 1;
    // 在后面的代码中不更新b
    long tb = b;
    while ((tb + tb) <= a) {
      // 最小解翻倍
      count = count + count;
      // 当前测试的值也翻倍
      tb = tb + tb;
    }
    return count + div(a - tb, b);
  }

}
