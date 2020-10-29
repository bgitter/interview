package com.zhang.interview.code.leetcode;

import java.util.Arrays;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ThreeSumClosest
 * @Author: zxb
 * @Date: 2020/10/29 9:43
 * @Description: leetcode16 最接近的三数之和 中等
 * 描述：给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 提示：
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 */
public class ThreeSumClosest {

  public static void main(String[] args) {
    int[] nums = {1, 3, 5, 7, 8};
    int res = new ThreeSumClosest().threeSumClosest(nums, 10);
    System.out.println("结果：" + res);
  }

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    long closest = Integer.MAX_VALUE;
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      // 已计算，跳过
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }

      long sum = 0;
      int p = i + 1, q = n - 1;
      while (p < q) {
        sum = nums[i] + nums[p] + nums[q];
        // 和目标值相等直接返回
        if (sum == target) {
          return target;
        }

        if (Math.abs(target - sum) < Math.abs(target - closest)) {
          closest = sum;
        }

        if (sum > target) {
          // 右指针减小
          while (--q > p && nums[q] == nums[q + 1]) {
          }
        } else {
          // 左指针增大
          while (++p < q && nums[p - 1] == nums[p]) {
          }
        }
      }
    }
    return (int) closest;
  }

}
