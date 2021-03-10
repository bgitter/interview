package com.zhang.interview.code.leetcode;

/**
 * @Copyright (C), 2018-2021, 北京数知科技股份有限公司
 * @FileName: SearchRotateSortArray
 * @Author: zxb
 * @Date: 2021/3/10 17:17
 * @Description: 搜索旋转排序数组
 * 描述：整数数组 nums 按升序排列，数组中的值互不相同。在传递给函数之前，nums 在预先未知的某个下标
 * k (0 <= k < nums.length)上进行了旋转，使数组变为 [nums[k], nums[k+1],..., nums[n-1], nums[0], nums[1], ...,
 * nums[k-1]] (下标从 0 开始计数)。例如，[0, 1, 2, 4, 5, 6, 7] 在下标 3 处经旋转后可能变为 [4, 5, 6, 7, 0, 1, 2]。
 * 给你旋转后的数组 nums 和一个整数 target，如果 nums 中存在这个目标值 target，则返回它的索引，否则返回 -1。
 * <p>
 * 示例1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * 示例2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * <p>
 * 示例3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * 提示：
 * - 1 <= nums.length <= 5000
 * - -10^4 <= nums[i] <= 10^4
 * - nums 中的每个值都是独一无二
 * - nums 肯定会在某个点上旋转
 * - -10^4 <= target <= 10^4
 * <p>
 * 进阶：
 * 你可以设计一个时间复杂度为 O(log n)的解决方案吗？
 * <p>
 * leetcode：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class SearchRotateSortArray {

  public static void main(String[] args) {
    int[] arr = {4, 5, 6, 7, 0, 1, 2};
    int idx = search(arr, 6);
    System.out.println("下标：" + idx);
  }

  /**
   * 二分查找法
   * 时间复杂度：O(log n)，其中 n 为nums数组的大小。整个算法时间复杂度即为二分查找的时间复杂度 O(log n)。
   * 空间复杂度：O(1)
   *
   * @param nums
   * @param target
   * @return
   */
  public static int search(int[] nums, int target) {
    int n = nums.length;
    if (n == 0) {
      return -1;
    }
    if (n == 1) {
      return nums[0] == target ? 0 : -1;
    }
    int l = 0, r = n - 1;
    while (l <= r) {
      int mid = (r + l) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[0] <= nums[mid]) {
        // 左侧部分有序
        if (nums[0] <= target && target < nums[mid]) {
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      } else {
        // 右侧部分有序
        if (nums[mid] < target && target <= nums[n - 1]) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
    }
    return -1;
  }

}
