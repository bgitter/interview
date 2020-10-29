package com.zhang.interview.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: FourSum
 * @Author: zxb
 * @Date: 2020/10/29 13:55
 * @Description: leetcode18 四数之和 中等
 * 描述：给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
 * d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class FourSum {

  public static void main(String[] args) {
    int[] nums = {1, 0, -1, 0, -2, 2};
    List<List<Integer>> res = new FourSum().fourSum(nums, 0);
    System.out.println("结果：" + Arrays.toString(res.toArray()));
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> data = new ArrayList<>();
    if (nums == null || nums.length < 4) {
      return data;
    }
    Arrays.sort(nums);
    int length = nums.length;
    for (int i = 0; i < length - 3; i++) {
      // 跳过
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      // i之后的元素都不能满足四数之和等于target
      if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
        break;
      }
      // i与最后三个元素之和小于target，当前i元素不满足要求，跳过
      if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
        continue;
      }
      for (int j = i + 1; j < length - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        // 已确定元素i和j，那么四数之和大于target，则j之后的元素都不能满足要求，跳出循环
        if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
          break;
        }
        // 已确定元素i和j与最后两个元素相加之和小于target，表名j需要变大，跳过本次循环
        if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
          continue;
        }
        // 双指针法
        int left = j + 1, right = length - 1;
        int sum = 0;
        while (left < right) {
          sum = nums[i] + nums[j] + nums[left] + nums[right];
          if (sum == target) {
            data.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
            while (left < right && nums[left] == nums[left + 1]) {
              left++;
            }
            left++;
            while (left < right && nums[right] == nums[right - 1]) {
              right--;
            }
            right--;
          } else if (sum < target) {
            left++;
          } else {
            right--;
          }
        }
      }
    }
    return data;
  }

}
