package com.zhang.interview.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: LetterCombinations
 * @Author: zxb
 * @Date: 2020/10/29 11:03
 * @Description: leetcode17 电话号码的字母组合 中等
 * 描述：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例：
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 说明：
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LetterCombinations {

  public static void main(String[] args) {
    List<String> res = new LetterCombinations().letterCombinations("232");
    System.out.println("结果：" + Arrays.toString(res.toArray()));
  }

  public List<String> letterCombinations(String digits) {
    List<String> combinations = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return combinations;
    }
    String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    backtrack(combinations, dict, digits, 0, new StringBuilder());
    return combinations;
  }

  public void backtrack(List<String> combinations, String[] dict, String digits, int idx,
      StringBuilder sb) {
    if (idx == digits.length()) {
      combinations.add(sb.toString());
    } else {
      char digit = digits.charAt(idx);
      String letters = dict[digit - '0'];
      int count = letters.length();
      for (int i = 0; i < count; i++) {
        sb.append(letters.charAt(i));
        backtrack(combinations, dict, digits, idx + 1, sb);
        sb.deleteCharAt(idx);
      }
    }
  }
}
