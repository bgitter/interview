package com.zhang.interview.code.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ValidParentheses
 * @Author: zxb
 * @Date: 2020/10/29 16:14
 * @Description: leetcode20 有效的括号 简单
 * 描述：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需要满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 注意：空字符串可被认为是有效字符串
 * <p>
 * 示例1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例5:
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidParentheses {

  public static void main(String[] args) {
    boolean flag = new ValidParentheses().isValid2("()");
    System.out.println("结果：" + flag);
  }

  public boolean isValid(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    if (s.length() % 2 == 1) {
      return false;
    }
    Map<Character, Character> hash = new HashMap<>(6);
    hash.put('}', '{');
    hash.put(']', '[');
    hash.put(')', '(');
    // 使用栈的方式处理
    Deque<Character> stack = new LinkedList<>();
    for (char c : s.toCharArray()) {
      if (hash.containsKey(c)) {
        if (stack.isEmpty() || !hash.get(c).equals(stack.peek())) {
          return false;
        }
        stack.pop();
      } else {
        stack.push(c);
      }
    }

    return stack.isEmpty();
  }

  public boolean isValid2(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    if (s.length() % 2 == 1) {
      return false;
    }
    while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
      s = s.replace("{}", "");
      s = s.replace("[]", "");
      s = s.replace("()", "");
    }
    return s.isEmpty();
  }
}
