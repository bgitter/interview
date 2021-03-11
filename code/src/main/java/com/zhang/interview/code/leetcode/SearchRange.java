package com.zhang.interview.code.leetcode;

import java.util.Arrays;

/**
 * @Copyright (C), 2018-2021, 北京数知科技股份有限公司
 * @FileName: SearchRange
 * @Author: zxb
 * @Date: 2021/3/10 18:02
 * @Description: 在排序数组中查找元素的第一个和最后一个位置
 * 描述：给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 示例1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * <p>
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 */
public class SearchRange {

  public static void main(String[] args) {
    int[] arr = {0, 1, 2, 9, 9, 10, 10, 10, 10, 15, 20, 20};
    int[] range = searchRange(arr, 10);
    System.out.println("搜索查找范围：" + Arrays.toString(range));
  }

  /**
   * 时间复杂度：O(log n)，其中 n 为数组的长度。二分查找的时间复杂度为 O(log n)，一共会执行两次，因此总时间复杂度为 O(log n)。
   * 空间复杂度：O(1)，只需要常数空间存放若干变量。
   *
   * @param nums
   * @param target
   * @return
   */
  public static int[] searchRange(int[] nums, int target) {
    int leftIdx = binarySearch(nums, target, true);
    int rightIdx = binarySearch(nums, target, false) - 1;
    if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target
        && nums[rightIdx] == target) {
      return new int[]{leftIdx, rightIdx};
    }
    return new int[]{-1, -1};
  }

  public static int binarySearch(int[] nums, int target, boolean lower) {
    int left = 0, right = nums.length - 1, ans = nums.length;
    while (left <= right) {
      int mid = (left + right) / 2;
      if ((nums[mid] > target) || (lower && nums[mid] >= target)) {
        right = mid - 1;
        ans = mid;
      } else {
        left = mid + 1;
      }
    }
    return ans;
  }

}
