package com.zhang.interview.code.leetcode;

/**
 * @Copyright (C), 2018-2021, 北京数知科技股份有限公司
 * @FileName: CountAndSay
 * @Author: zxb
 * @Date: 2021/3/11 15:55
 * @Description: 外观数列
 * 描述：给定一个正整数 n，输出外观数列的第 n 项。
 * [外观数列] 是一个整数数列，从数字 1 开始，数列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * - countAndSay(1) = "1"
 * - countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * <p>
 * 前五项如下：
 * 1.   1
 * 2.   11
 * 3.   12
 * 4.   1211
 * 5.   111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “一个 1”，记作“11”
 * 描述前一项，这个数是 11 即 “二个 1”，记作“21”
 * 描述前一项，这个数是 21 即 “一个 2 + 一个 1”，记作“1211”
 * 描述前一项，这个数是 1211 即 “一个 1 + 一个 2 + 二个 1”，记作 “111221”
 * <p>
 * 要描述一个数字字符串，首先要将字符串分割为最小数量的组，每个组都由连续的最多相同字符组成。然后对于
 * 每个组，先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，先将每组中的字符
 * 数量用数字替换，再将所有描述组连接起来。
 * leetcode：https://leetcode-cn.com/problems/count-and-say/
 */
public class CountAndSay {

  public static void main(String[] args) {
    String r = countAndSay(3);
    System.out.println("外观数列为：" + r);
  }

  public static String countAndSay(int n) {
    // 递归结束条件
    if (n == 1) {
      return "1";
    }
    // 递归处理，上一轮的输出是下一轮的输入
    String str = countAndSay(n - 1);
    // 存放当前轮答案
    StringBuilder ans = new StringBuilder();
    int len = str.length();
    /**
     * 递归代码最神的地方，一个循环可以展现出 n 个嵌套for循环的作用，可以好好体会这里的算法在
     * 初级算法 Lc中经常用到，当与前一个元素不一样时触发函数。
     * 注意从1开始是为了方便对比，相应的长度也+1方便对比。
     */
    // 记录开始下标
    int start = 0;
    for (int i = 1; i < len + 1; i++) {
      if (i == len) {
        // 最后一个元素单独处理
        ans.append(i - start).append(str.charAt(start));
      } else if (str.charAt(i) != str.charAt(start)) {
        // 元素改变触发函数
        ans.append(i - start).append(str.charAt(start));
        // 更新起始下标
        start = i;
      }
    }
    return ans.toString();
  }
}
