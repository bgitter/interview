package com.zhang.interview.code.leetcode;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: LongestPalindrome
 * @Author: zxb
 * @Date: 2020/10/22 17:15
 * @Description: leetcode5 最长回文子串 中等
 * 描述：给定一个字符串s，找到s中最长的回文子串。你可以假设s的最大长度为1000。
 * <p>
 * 示例 1:
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案
 * <p>
 * 示例 2:
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 资料：
 * https://www.cxyxiaowu.com/2869.html
 * https://www.toutiao.com/i6542501325152715277
 * manacher算法可视化讲解：http://manacher-viz.s3-website-us-east-1.amazonaws.com/#/
 */
public class LongestPalindrome {

  public static void main(String[] args) {
    String str = "aabbaa";
    // String result = solution1(str);
    // String result = solution2(str);
    String result = solution3(str);
    System.out.println("最长回文子串：" + result);
  }

  /**
   * 暴力枚举法
   * 求解过程中分别以每个元素为中间元素（奇数为最中间的一个数，偶数为中间元素的其中一个），同时从左右
   * 出发，计算出最长的回文子串。
   * 复杂度分析
   * - 时间复杂度：最外层循环复杂度为O(n)，内层两个循环复杂度都为O(n/2)，因此时间复杂度为O(n^2)。
   * - 空间复杂度：在此算法中，没有使用额外的辅助空间，因此空间复杂度为O(1)。
   *
   * @param str 字符串
   * @return 最长回文子串
   */
  private static String solution1(String str) {
    int startIndex = 0;
    int endIndex = 0;

    // 保存最大回文子串的起始与终点位置
    int resStart = 0;
    int resEnd = 0;
    int maxLen = 0;
    int countLen = 0;

    int length = str.length();
    for (int i = 0; i < length; i++) {
      // 回文子串为奇数串处理
      startIndex = i;
      endIndex = i;
      countLen = 0;
      while (startIndex >= 0 && endIndex < length) {
        if (str.charAt(startIndex) == str.charAt(endIndex)) {
          if (startIndex == endIndex) {
            countLen++;
          } else {
            countLen += 2;
          }
          startIndex--;
          endIndex++;
        } else {
          break;
        }
      }
      // 当前回文子串大于上一次最大回文子串
      if (countLen > maxLen) {
        maxLen = countLen;
        resStart = startIndex + 1;
        resEnd = endIndex - 1;
      }

      // 回文子串为偶数串处理
      startIndex = i - 1;
      endIndex = i;
      countLen = 0;
      while (startIndex >= 0 && endIndex < length) {
        if (str.charAt(startIndex) == str.charAt(endIndex)) {
          if (startIndex == endIndex) {
            countLen++;
          } else {
            countLen += 2;
          }
          startIndex--;
          endIndex++;
        } else {
          break;
        }
      }
      // 当前回文子串大于上一次最大回文子串
      if (countLen > maxLen) {
        maxLen = countLen;
        resStart = startIndex + 1;
        resEnd = endIndex - 1;
      }
    }
    return str.substring(resStart, resEnd + 1);
  }

  /**
   * 记忆化搜索 - 动态规划
   * 回文字符串的子串也是回文，我们可以将最长回文子串分解一系列子问题，使用动态规划求解。
   * 设状态 f(i,j)表示区间[i,j]是否为回文串，f(i,j) = false 表示子串[i,j]不是回文，f(i,j) =
   * true 表示子串[i,j]是回文串，则有以下的关系：
   * <p>
   * 复杂度分析
   * - 时间复杂度：使用了两层循环，因此时间复杂度为O(n^2)。
   * - 空间复杂度：使用f[n][n]作为辅助空间，因此空间复杂度为O(n^2)。
   *
   * @param str 字符串
   * @return 最长回文子串
   */
  private static String solution2(String str) {
    int length = str.length();
    boolean[][] f = new boolean[length][];

    // 构建二维数组
    for (int i = 0; i < length; i++) {
      f[i] = new boolean[length];
    }
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        f[i][j] = false;
      }
    }

    int maxLen = 1;
    int start = 0;
    for (int i = 0; i < length; i++) {
      f[i][i] = true;
      for (int j = 0; j < i; j++) {
        f[j][i] = (str.charAt(j) == str.charAt(i) && (i - j < 2 || f[j + 1][i - 1]));
        if (f[j][i] && maxLen < (i - j + 1)) {
          maxLen = i - j + 1;
          start = j;
        }
      }
    }
    f = null;
    return str.substring(start, start + maxLen);
  }

  /**
   * Mancher's Algorithm
   * Mancher 算法能够很快的得到一个字符串以任意一个字符为中心的回文子串，其基本原理使用已知回文串的左
   * 半部分来推导右半部分。
   * <p>
   * 复杂度分析
   * - 时间复杂度：Mancher算法时间复杂度为O(n)。
   * - 空间复杂度：空间复杂度也为O(n)。
   *
   * @param str 字符串
   * @return 最长回文子串
   */
  private static String solution3(String str) {
    String temp = preProcess(str);

    int len = temp.length();
    int[] rad = new int[len];
    int center = 0;
    int maxRight = 0;

    for (int i = 1; i < len - 1; i++) {
      int symPos = 2 * center - 1;
      rad[i] = (maxRight > i) ? Math.min(maxRight - i, rad[symPos]) : 1;

      // 以i为中心检索两边的字符串
      while (temp.charAt(i + rad[i]) == temp.charAt(i - rad[i])) {
        rad[i]++;
      }

      if (i + rad[i] > maxRight) {
        center = i;
        maxRight = i + rad[i];
      }
    }

    // 寻找最长的半径
    int maxLen = 0;
    int centerIdx = 0;
    for (int i = 1; i < len - 1; i++) {
      if (rad[i] > maxLen) {
        maxLen = rad[i];
        centerIdx = i;
      }
    }

    return str.substring((centerIdx - maxLen) / 2, maxLen);
  }

  private static String preProcess(String s) {
    if (s == null || s.length() == 0) {
      return "^$";
    }
    StringBuilder sb = new StringBuilder("^");
    for (int i = 0; i < s.length(); i++) {
      sb.append("#").append(s.charAt(i));
    }
    sb.append("$");
    return sb.toString();
  }
}
