package com.zhang.interview.code.leetcode;

import java.util.Arrays;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: RemoveDuplicatesFromArray
 * @Author: zxb
 * @Date: 2020/10/30 18:05
 * @Description: leetcode26 删除排序数组中的重复项 简单
 * 描述：给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例1：
 * 给定数组 nums = [1,1,2], 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例2：
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 说明：
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 */
public class RemoveDuplicatesFromArray {

  public static void main(String[] args) {
    int[] nums = {1, 1, 2, 2, 3, 4, 5};
    int res = new RemoveDuplicatesFromArray().removeDuplicates(nums);
    System.out.println("更新后数组：" + nums + ", 长度：" + Arrays.toString(nums));
  }

  public int removeDuplicates(int[] nums) {
    int prev = nums[0], idx = 0;
    for (int i = 1; i < nums.length; i++) {
      // 跳过重复元素
      while (i < nums.length && prev == nums[i]) {
        i++;
      }
      if (idx + 1 < i) {
        // 移除重复元素
        int start = i - 1;
        for (int j = idx + 1; j < nums.length; j++) {
          if (start < nums.length) {
            nums[j] = nums[start];
          } else {
            nums[j] = 0;
          }
          start++;
        }
      }
      prev = nums[i];
      idx = i;
    }
    return nums.length;
  }

}
