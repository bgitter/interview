package com.zhang.interview.code.leetcode.primary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: TwoSum
 * @Author: zxb
 * @Date: 2020/9/26 17:42
 * @Description: 两数之和
 * 描述：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，
 * 并返回他们的数组下标。
 * 注：你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 解题思路：
 * 1.在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素；
 * 2.如果它存在，那我们已经找到了对应解，并立即将其返回
 * <p>
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 */
public class TwoSum {

  private static final Integer TARGET = 9;

  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    int[] result = twoSum(nums);
    System.out.println(Arrays.toString(result));
  }

  private static int[] twoSum(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      int complement = TARGET - nums[i];
      if (map.containsKey(complement)) {
        return new int[]{map.get(complement), i};
      }
      map.put(nums[i], i);
    }
    return null;
  }
}
