package com.zhang.interview.code.leetcode;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: MedianOfTwoSortedArrays
 * @Author: zxb
 * @Date: 2020/10/22 11:39
 * @Description: leetcode4 寻找两个正序数组的中位数 困难
 * 描述：给定两个大小为m和n的正序（从小到大）数组 nums1和nums2.请你找出并返回这两个正序数组的
 * 中位数。
 * 进阶：你能设计一个时间复杂度为 O(log(m+n))的算法解决此问题吗？
 * 示例 1:
 * 输入: nums1 = [1,3], nums2=[2]
 * 输出: 2.0
 * 解释: 合并数组 = [1,2,3]，中位数 2
 * <p>
 * 示例 2:
 * 输入: nums1 = [1,2], nums2 = [3,4]
 * 输出: 2.5
 * 解释: 合并数组 = [1,2,3,4]，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 示例 3:
 * 输入: nums1 = [0,0], nums2 = [0,0]
 * 输出: 0
 * <p>
 * 示例 4:
 * 输入: nums1 = [], nums2 = [1]
 * 输出: 1
 * <p>
 * 示例 5:
 * 输入: nums1 = [2], nums2 = []
 * 输出: 2
 * <p>
 * 资料：https://www.cnblogs.com/tqlin/p/12192201.html
 * https://www.cnblogs.com/voidsky/p/5373982.html
 */
public class MedianOfTwoSortedArrays {

  public static void main(String[] args) {
    int[] a = {2};
    int[] b = {};
    double m = findMedianSortedArrays(a, b);
    System.out.println("中位数为：" + m);
  }

  private static double findMedianSortedArrays(int[] a, int[] b) {
    int m = a.length;
    int n = b.length;
    if (m > n) {
      // 保证 m <= n
      return findMedianSortedArrays(b, a);
    }
    int iMin = 0, iMax = m;
    while (iMin <= iMax) {
      // 数组A的cut点
      int i = (iMin + iMax) / 2;
      // 数组B的cut点
      int j = (m + n + 1) / 2 - i;

      // i需要增大，相应的j会减小，因此j不能==0
      if (j != 0 && i != m && b[j - 1] > a[i]) {
        iMin = i + 1;
      }

      // i需要减小，相应的j会增大，因此j不能==n
      else if (i != 0 && j != n && a[i - 1] > b[j]) {
        iMax = i - 1;
      }

      // 达到要求，并且将边界条件列出来单独考虑
      else {
        int maxLeft = 0;
        if (i == 0) {
          maxLeft = b[j - 1];
        } else if (j == 0) {
          maxLeft = a[i - 1];
        } else {
          maxLeft = Math.max(a[i - 1], b[j - 1]);
        }
        // 奇数的话不需要考虑有半部分
        if ((m + n) % 2 == 1) {
          return maxLeft;
        }

        int minRight = 0;
        if (i == m) {
          minRight = b[j];
        } else if (j == n) {
          minRight = a[i];
        } else {
          minRight = Math.min(b[j], a[i]);
        }
        // 如果是偶数的话返回结果
        return (maxLeft + minRight) / 2;
      }
    }
    return 0;
  }
}
