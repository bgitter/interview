package com.zhang.interview.code.leetcode;

import java.util.Arrays;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: DfsPermutation
 * @Author: zxb
 * @Date: 2020/9/28 9:17
 * @Description: 全排列算法
 */
public class DfsPermutation {

  /**
   * 1~N 的全排列
   */
  private static final int N = 6;
  /**
   * 用来存放N个排列的数组（盒子）
   */
  private static int[] box = new int[N];
  /**
   * 对使用过的数字进行标识，数字即下标
   */
  private static int[] book = new int[N + 1];

  public static void main(String[] args) {
    dfsPermutation(0);
  }

  private static void dfsPermutation(int idx) {
    if (idx == N) {
      System.out.println(Arrays.toString(box));
      return;
    }
    // 每个盒子可以放入 1~N个数字，每个状态有N次尝试
    for (int i = 1; i <= N; i++) {
      // 加入数字的时候有限制条件，只能使用未用过的数字i，未用过的数字的标记位 book[i] == 0
      if (book[i] == 0) {
        // 把数字i放入到box数组，生成全排列
        box[idx] = i;
        // 标记当前数字i已被使用了
        book[i] = 1;
        dfsPermutation(idx + 1);

        // 从上一个状态返回时，清空i的使用标记，进行下一个尝试
        book[i] = 0;
        System.out.println("当前box：" + Arrays.toString(box) + ">>> i: " + i + " >>> index: " + idx);
      }
    }
  }
}
