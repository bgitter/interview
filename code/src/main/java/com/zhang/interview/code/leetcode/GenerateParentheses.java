package com.zhang.interview.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: GenerateParentheses
 * @Author: zxb
 * @Date: 2020/10/30 9:47
 * @Description: leetcode22 括号生成 中等
 * 描述：数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例：
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParentheses {

  public static void main(String[] args) {
    List<String> res = new GenerateParentheses().generateParenthesis3(3);
    System.out.println("结果：" + Arrays.toString(res.toArray()));
  }

  /**
   * 暴力解
   *
   * @param n n个数
   * @return 有效解
   */
  public List<String> generateParenthesis(int n) {
    List<String> combinations = new ArrayList<>();
    if (n <= 0) {
      return combinations;
    }
    generateAll(new char[2 * n], 0, combinations);
    return combinations;
  }

  /**
   * 回溯算法
   *
   * @param n n个数
   * @return 有效解
   */
  public List<String> generateParenthesis2(int n) {
    List<String> ans = new ArrayList<>();
    if (n <= 0) {
      return ans;
    }
    backtrack(ans, new StringBuilder(), 0, 0, n);
    return ans;
  }

  /**
   * 其他解
   *
   * @param n
   * @return
   */
  public List<String> generateParenthesis3(int n) {
    List<String> ans = new ArrayList<>();
    if (n <= 0) {
      return ans;
    }
    getParenthesis(ans, "", n, n);
    return ans;
  }

  public void generateAll(char[] current, int pos, List<String> combinations) {
    if (pos == current.length) {
      if (valid(current)) {
        combinations.add(new String(current));
      }
    } else {
      current[pos] = '(';
      generateAll(current, pos + 1, combinations);
      current[pos] = ')';
      generateAll(current, pos + 1, combinations);
    }
  }

  public boolean valid(char[] current) {
    int balance = 0;
    for (char c : current) {
      if (c == '(') {
        balance++;
      } else {
        balance--;
      }
      if (balance < 0) {
        return false;
      }
    }
    return balance == 0;
  }

  public void backtrack(List<String> ans, StringBuilder sb, int open, int close, int max) {
    if (sb.length() == max * 2) {
      if (valid(sb.toString().toCharArray())) {
        ans.add(sb.toString());
      }
      return;
    }
    if (open < max) {
      sb.append("(");
      backtrack(ans, sb, open + 1, close, max);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (close < open) {
      sb.append(")");
      backtrack(ans, sb, open, close - 1, max);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  public void getParenthesis(List<String> ans, String str, int left, int right) {
    if (left == 0 && right == 0) {
      ans.add(str);
      return;
    }

    if (left == right) {
      // 剩余左右括号数相等，下一个只能是左括号
      getParenthesis(ans, str + "(", left - 1, right);
    } else if (left < right) {
      // 剩余左括号小于右括号，下一个可以用左括号也可以用右括号
      if (left > 0) {
        getParenthesis(ans, str + "(", left - 1, right);
      }
      getParenthesis(ans, str + ")", left, right - 1);
    }
  }
}
