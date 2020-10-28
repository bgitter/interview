package com.zhang.interview.code.leetcode;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ContainerWithMostWater
 * @Author: zxb
 * @Date: 2020/10/27 17:40
 * @Description: leetcode11 盛最多水的容器 中等
 * 描述：给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i,
 * 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 示例:
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class ContainerWithMostWater {

  public static void main(String[] args) {
    int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    // int res = new ContainerWithMostWater().maxArea(height);
    int res = new ContainerWithMostWater().maxAreaPoint(height);
    System.out.println("最大面积：" + res);
  }

  /**
   * 暴力破解
   * 时间复杂度：O(n^2)
   * 空间复杂度：O(1)
   *
   * @param height 数组
   * @return 最大面积
   */
  public int maxArea(int[] height) {
    int maxArea = 0;
    for (int i = 0; i < height.length - 1; i++) {
      for (int j = i + 1; j < height.length; j++) {
        maxArea = Math.max((j - i) * Math.min(height[i], height[j]), maxArea);
      }
    }
    return maxArea;
  }

  /**
   * 双指针
   * 时间复杂度：O(n)
   * 空间复杂度：O(1)
   *
   * @param height 数组
   * @return 最大面积
   */
  public int maxAreaPoint(int[] height) {
    int maxArea = 0, l = 0, r = height.length - 1;
    while (l < r) {
      maxArea = Math.max((r - l) * Math.min(height[l], height[r]), maxArea);
      if (height[l] < height[r]) {
        l++;
      } else {
        r--;
      }
    }
    return maxArea;
  }
}
