package com.zhang.interview.code.leetcode;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: RegularExpressionMatching
 * @Author: zxb
 * @Date: 2020/10/27 14:31
 * @Description: leetcode10 正则表达式 困难
 * 描述：给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * - '.' 匹配任意单个字符
 * - '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串
 * <p>
 * 示例1:
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例2:
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * 示例3:
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 * 示例4:
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * <p>
 * 示例5:
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 * <p>
 * 提示：
 * 0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 */
public class RegularExpressionMatching {

  public static void main(String[] args) {
    boolean flag = new RegularExpressionMatching().isMatch("abc", "a.c");
    System.out.println("是否匹配：" + flag);
  }

  public boolean isMatch(String s, String p) {
    int m = s.length();
    int n = p.length();

    boolean[][] f = new boolean[m + 1][n + 1];
    f[0][0] = true;
    for (int i = 0; i <= m; ++i) {
      for (int j = 1; j <= n; ++j) {
        if (p.charAt(j - 1) == '*') {
          f[i][j] = f[i][j - 2];
          if (matches(s, p, i, j - 1)) {
            f[i][j] = f[i][j] || f[i - 1][j];
          }
        } else {
          if (matches(s, p, i, j)) {
            f[i][j] = f[i - 1][j - 1];
          }
        }
      }
    }
    return f[m][n];
  }

  public boolean matches(String s, String p, int i, int j) {
    if (i == 0) {
      return false;
    }
    if (p.charAt(j - 1) == '.') {
      return true;
    }
    return s.charAt(i - 1) == p.charAt(j - 1);
  }
}
