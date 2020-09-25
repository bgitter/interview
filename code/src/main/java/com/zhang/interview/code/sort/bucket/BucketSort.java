package com.zhang.interview.code.sort.bucket;

import com.zhang.interview.code.sort.BaseSort;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: BucketSort
 * @Author: zxb
 * @Date: 2020/9/26 6:34
 * @Description: 桶排序
 * 思路： <br>
 * 1找出最大值，最小值； <br>
 * 2.根据数组长度，创建若干桶； <br>
 * 3.遍历数组元素，根据元素的值放入到对应的桶中； <br>
 * 4.对每个桶的元素进行排序（可使用快排，插入排序等）； <br>
 * 5.按顺序合并每个桶的元素，排序完成。 <br/>
 * <p>
 * 时间复杂度：O(M+1) <br>
 * 空间复杂度：O(M+N) <br>
 * 是否稳定：稳定（取决于桶内排序算法的选择，这里使用的是插入排序所以是稳定的）
 * <p>
 * 注：对于数组中元素分布均匀的情况，排序效率高。相反的，如果分布不均匀，则会导致大部分的数据落入到同一个桶中，
 * 使效率降低。
 */
public class BucketSort extends BaseSort {

  public static void main(String[] args) {
    BucketSort sort = new BucketSort();
    sort.printNums();
  }

  @Override
  protected void sort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    bucketSort(arr);
  }

  private void bucketSort(int[] nums) {
    // 找出最大值，最小值
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int num : nums) {
      max = Math.max(max, num);
      min = Math.min(min, num);
    }
    int length = nums.length;
    // 桶的数量
    int bucketNum = (max - min) / length + 1;
    int[][] bucketArrays = new int[bucketNum][];
    // 遍历数组，放入桶内
    for (int i = 0; i < length - 1; i++) {
      // 找到桶下标
      int idx = (nums[i] - min) / length;
      // 添加到指定下标的桶里，并且使用插入排序算法
      bucketArrays[idx] = insertSortArrays(bucketArrays[idx], nums[i]);
    }
    int k = 0;
    // 合并全部桶
    for (int[] bucket : bucketArrays) {
      if (bucket == null || bucket.length == 0) {
        continue;
      }
      for (int v : bucket) {
        // 把值放回到nums数组中
        nums[k++] = v;
      }
    }
  }

  /**
   * 向数组内添加一个元素，并使用插入排序进行排序
   *
   * @param nums 数组
   * @param num  元素
   * @return 排序后的数组
   */
  private static int[] insertSortArrays(int[] nums, int num) {
    if (nums == null || nums.length == 0) {
      return new int[]{num};
    }
    // 创建一个temp临时数组，长度是 nums 数组的长度 + 1
    int[] temp = new int[nums.length + 1];
    // 把传进来的数组复制到临时数组
    for (int i = 0; i < nums.length; i++) {
      temp[i] = nums[i];
    }
    // 找到一个位置，插入，形成新的有序的数组
    int j;
    for (j = temp.length - 2; j >= 0 && temp[j] > num; j--) {
      temp[j + 1] = temp[j];
    }
    // 插入需要添加的值
    temp[j + 1] = num;
    return temp;
  }
}
