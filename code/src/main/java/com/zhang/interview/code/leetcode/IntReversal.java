package com.zhang.interview.code.leetcode;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: IntReversal
 * @Author: zxb
 * @Date: 2020/10/21 18:12
 * @Description: Leetcode7 整数反转
 * 描述：给出一个32位的有符号整数，你需要将这个整数中每位上的数字进行反转
 */
public class IntReversal {

  private static final int factor = 10;

  public static void main(String[] args) {
    int num = 123456780;
    int sign = num >= 0 ? 1 : -1;
    long result = sign * reversal(Math.abs(num));
    System.out.println("整数反转结果：" + result);
  }

  private static int reversal(int num) {
    long result = 0;
    while (num > 0) {
      // 拼接结果
      result = result * factor + num % factor;
      num /= factor;
    }
    // 反转结果如果超过Integer取值范围，则返回0
    if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
      result = 0;
    }
    return (int) result;
  }
}
