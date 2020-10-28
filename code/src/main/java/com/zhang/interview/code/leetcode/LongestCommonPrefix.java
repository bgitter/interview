package com.zhang.interview.code.leetcode;

import java.util.function.BiFunction;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: LongestCommonPrefix
 * @Author: zxb
 * @Date: 2020/10/28 14:24
 * @Description: leetcode14 最长公共前缀 简单
 * 描述：编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明：
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {

  public static void main(String[] args) {
    String[] strs = {"leet", "leed", "leetscode"};
    String prefix = new LongestCommonPrefix().longestCommonPrefix4(strs);
    System.out.println("最长前缀：" + prefix);
  }

  /**
   * 横向法
   * m表示字符串数组中的字符串的平均长度，n是字符串的数量
   * 时间复杂度：O(mn)
   * 空间复杂度：O(1)
   *
   * @param strs 数组
   * @return 最长前缀
   */
  public String longestCommonPrefix1(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }

    BiFunction<String, String, String> func = (s1, s2) -> {
      int length = Math.min(s1.length(), s2.length());
      int idx = 0;
      while (idx < length && s1.charAt(idx) == s2.charAt(idx)) {
        idx++;
      }
      return s1.substring(0, idx);
    };

    String prefix = strs[0];
    int len = strs.length;
    for (int i = 1; i < len; i++) {
      prefix = func.apply(prefix, strs[i]);
      if (prefix.length() == 0) {
        break;
      }
    }

    return prefix;
  }

  /**
   * 纵向法
   * m表示字符串数组中的字符串的平均长度，n是字符串的数量
   * 时间复杂度：O(mn)
   * 空间复杂度：O(1)
   *
   * @param strs 数组
   * @return 最长前缀
   */
  public String longestCommonPrefix2(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }

    // 使用数组内第一个字符串作为外部循环条件
    int length = strs[0].length();
    // 数组长度
    int count = strs.length;
    for (int i = 0; i < length; i++) {
      char c = strs[0].charAt(i);
      for (int j = 1; j < count; j++) {
        if (i == strs[j].length() || strs[j].charAt(i) != c) {
          return strs[0].substring(0, i);
        }
      }
    }

    return strs[0];
  }

  /**
   * 分治法
   * m表示字符串数组中的字符串的平均长度，n是字符串的数量
   * 时间复杂度：O(mn)
   * 空间复杂度：O(mlogn)
   *
   * @param strs 数组
   * @return 最长前缀
   */
  public String longestCommonPrefix3(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    } else {
      return longestCommonPrefix(strs, 0, strs.length - 1);
    }
  }

  public String longestCommonPrefix(String[] strs, int start, int end) {
    if (start == end) {
      return strs[start];
    } else {
      int mid = (end - start) / 2 + start;
      String left = longestCommonPrefix(strs, start, mid);
      String right = longestCommonPrefix(strs, mid + 1, end);
      return commonPrefix(left, right);
    }
  }

  public String commonPrefix(String left, String right) {
    int min = Math.min(left.length(), right.length());
    for (int i = 0; i < min; i++) {
      if (left.charAt(i) != right.charAt(i)) {
        return left.substring(0, i);
      }
    }
    return left.substring(0, min);
  }

  /**
   * 二分查找法
   * m表示字符串数组中的字符串的平均长度，n是字符串的数量
   * 时间复杂度：O(mn logm)
   * 空间复杂度：O(1)
   *
   * @param strs
   * @return
   */
  public String longestCommonPrefix4(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    // 最短字符串长度，防止越界
    int minLen = Integer.MAX_VALUE;
    for (String str : strs) {
      minLen = Math.min(str.length(), minLen);
    }
    int low = 0, high = minLen;
    while (low < high) {
      int mid = (high - low + 1) / 2 + low;
      if (isCommonPrefix(strs, mid)) {
        low = mid;
      } else {
        high = mid - 1;
      }
    }
    return strs[0].substring(0, low);
  }

  public boolean isCommonPrefix(String[] strs, int length) {
    String str0 = strs[0].substring(0, length);
    int count = strs.length;
    for (int i = 1; i < count; i++) {
      String str = strs[i];
      for (int j = 0; j < length; j++) {
        if (str0.charAt(j) != str.charAt(j)) {
          return false;
        }
      }
    }
    return true;
  }
}
