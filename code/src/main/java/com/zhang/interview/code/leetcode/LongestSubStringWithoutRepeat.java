package com.zhang.interview.code.leetcode;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: LongestSubStringWithoutRepeat
 * @Author: zxb
 * @Date: 2020/10/22 10:21
 * @Description: leetcode3 无重复字符的最长子串 中等
 * 描述：给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * 示例 1:
 * 输入："abcabcbb"
 * 输出：3
 * 解释：因为无重复字符的最长字串是“abc”，所以其长度为3。
 * 示例 2:
 * 输入："bbbbb"
 * 输出：1
 * 解释：因为无重复字符的最长字串是"b"，所以其长度为1。
 * 示例 3:
 * 输入："pwwkew"
 * 输出：3
 * 解释：因为无重复字符的最长子串是"wke"，所以其长度为3。
 * <p>
 * 注意：你的答案必须是<b>子串</b>的长度，"pwke"是一个子序列，不是子串。
 */
public class LongestSubStringWithoutRepeat {

  public static void main(String[] args) {
    String str = "pwwkew";
    int res = lengthOfLongestSubstring(str);
    System.out.println("不重复的子串长度为：" + res);
  }

  private static int lengthOfLongestSubstring(String str) {
    if (str == null || str.length() < 1) {
      return 0;
    }
    int length = str.length();
    // 定义两个指针，其间为不重复的元素
    int i = 0;
    int j = 0;
    int res = 0;
    int[] map = new int[256];
    while (i < length) {
      if (j < length && map[str.charAt(j)] == 0) {
        map[str.charAt(j++)]++;
        res = Math.max(res, j - i);
      } else {
        map[str.charAt(i++)]--;
      }
    }
    return res;
  }
}
