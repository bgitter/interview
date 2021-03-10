package com.zhang.interview.code.leetcode;

/**
 * @Copyright (C), 2018-2021, 北京数知科技股份有限公司
 * @FileName: StrStr
 * @Author: zxb
 * @Date: 2021/3/10 11:35
 * @Description: 实现 strStr() 函数
 * 描述：给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例1：
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 示例2：
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * <p>
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * leetcode地址：https://leetcode-cn.com/problems/implement-strstr/solution/shi-xian-strstr-by-leetcode/#comment
 */
public class StrStr {

  public static void main(String[] args) {
    int idx = strStr3("hello", "ll");
    System.out.println("出现的第一个位置：" + idx);
  }

  /**
   * 时间复杂度：O((N-L) L)，其中 N 为 haystack 字符串的长度，L 为 needle 字符串的长度。内循环中比较字符串的复杂度为L，总共需要比较(N-L)次。
   * 空间复杂度：O(1)。
   *
   * @param haystack
   * @param needle
   * @return
   */
  public static int strStr1(String haystack, String needle) {
    int L = needle.length(), n = haystack.length();
    for (int start = 0; start < n - L + 1; ++start) {
      if (haystack.substring(start, start + L).equals(needle)) {
        return start;
      }
    }
    return -1;
  }

  /**
   * 双指针 - 线性时间复杂度
   * 算法：
   * 1.移动 pn指针，直到 pn 所指向位置的字符与 needle 字符串第一个字符串相等。
   * 2.通过 pn，pL，curr_len 计算匹配长度。
   * 3.如果完全匹配（即 curr_len == L），返回匹配子串的起始坐标（即 pn-L）。
   * 4.如果不完全匹配，回溯。使 pn=pn-curr_len + 1， pL=0， curr_len = 0.
   * <p>
   * 时间复杂度：最坏时间复杂度为 O((N - L) L)，最优时间复杂度为 O(N)。
   * 空间复杂度：O(1)。
   *
   * @param haystack
   * @param needle
   * @return
   */
  public static int strStr2(String haystack, String needle) {
    int L = needle.length(), n = haystack.length();
    if (L == 0) {
      return 0;
    }

    int pn = 0;
    while (pn < n - L + 1) {
      // find the position of the first needle character in the haystack string
      while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) {
        ++pn;
      }

      // compute the max match string
      int currLen = 0, pL = 0;
      while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
        ++pn;
        ++pL;
        ++currLen;
      }

      // if the whole needle string is found, return its start position
      if (currLen == L) {
        return pn - L;
      }

      // otherwise, backtrack
      pn = pn - currLen + 1;
    }
    return -1;
  }

  /**
   * Rabin Karp - 常数复杂度
   * 算法：
   * 1.计算子字符串 haystack.substring(0, L) 和 needle.substring(0, L) 的哈希值。
   * 2.从起始位置开始遍历：从第一个字符串遍历到第 N - L 个字符。
   * - a.根据前一个哈希值计算滚动哈希。
   * - b.如果子字符串哈希值与 needle 字符串哈希值相等，返回滑动窗口起始位置。
   * 3.返回 -1，这时候 haystack 字符串中不存在 needle 字符串。
   * <p>
   * 时间复杂度：O(N)，计算 needle 字符串的哈希值需要 O(L)时间，之后需要执行(N - L)次循环，每次循环的计算复杂度为常数。
   * 空间复杂度：O(1)。
   *
   * @param haystack
   * @param needle
   * @return
   */
  public static int strStr3(String haystack, String needle) {
    int L = needle.length(), n = haystack.length();
    if (L > n) {
      return -1;
    }
    // base value for the rolling hash function
    int a = 26;
    // modules value for the rolling hash function to avoid overflow
    long modules = (long) Math.pow(2, 31);
    // compute the hash of strings haystack[:L]，needle[:L]
    long h = 0, ref_h = 0;
    for (int i = 0; i < L; ++i) {
      h = (h * a + charToInt(i, haystack)) % modules;
      ref_h = (ref_h * a + charToInt(i, needle)) % modules;
    }
    if (h == ref_h) {
      return 0;
    }

    // const value to be used often：a**L % modules
    long aL = 1;
    for (int i = 1; i <= L; ++i) {
      aL = (aL * a) % modules;
    }

    for (int start = 1; start < n - L + 1; ++start) {
      // compute rolling hash in O(1) time
      h = (h * a - charToInt(start - 1, haystack) * aL + charToInt(start + L - 1, haystack))
          % modules;
      if (h == ref_h) {
        return start;
      }
    }
    return -1;
  }

  /**
   * function to convert character to integer
   *
   * @param idx
   * @param s
   * @return
   */
  static int charToInt(int idx, String s) {
    return (int) s.charAt(idx) - (int) 'a';
  }
}
