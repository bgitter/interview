package com.zhang.interview.code.leetcode;

import java.util.Arrays;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ZigzagConversion
 * @Author: zxb
 * @Date: 2020/10/26 16:05
 * @Description: leetcode6 Z字形变换 中等
 * 描述：将一个给定字符串根据给定的行数，以从上往下，从左到右进行Z字形排列。
 * 比如输入字符串为"LEETCODEISHIRING"行数为3时，排列如下：
 * ```
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * ```
 * 之后，你的输出需要从左往右逐行读取，产生一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行制定行数变换的函数：
 * ```
 * string convert(string s, int numRows);
 * ```
 * <p>
 * 示例1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * <p>
 * 示例2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 */
public class ZigzagConversion {

  public static void main(String[] args) {
    String result = new ZigzagConversion().convert("PAYPALISHIRING", 4);
    System.out.println("结果为：" + result);
  }

  public String convert(String s, int numRows) {
    if (s == null || s.length() == 0 || numRows == 1) {
      return s;
    }
    StringBuilder[] array = new StringBuilder[numRows];
    for (int i = 0; i < numRows; i++) {
      array[i] = new StringBuilder();
    }
    int dir = 1;
    // 定义数组索引
    int idx = 0;
    for (char c : s.toCharArray()) {
      array[idx].append(c);
      idx += dir;
      if (idx == 0 || idx == numRows - 1) {
        dir = -dir;
      }
    }
    StringBuilder result = new StringBuilder();
    Arrays.stream(array).forEach(sb -> result.append(sb));
    return result.toString();
  }
}
