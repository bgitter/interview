package com.zhang.interview.code.sort.heap;

import com.zhang.interview.code.sort.BaseSort;

/**
 * @ClassName: HeapSort <br>
 * @Description: 堆排序 <br>
 * 1.对原数组构建成大顶堆； <br>
 * 2.交换头尾值，尾指索引减 1，固定最大值； <br>
 * 3.重新构建大顶堆； <br>
 * 4.重复步骤2~3，直到最后一个元素，排序完成。
 * <p>
 * 时间复杂度： O(nlogn) <br>
 * 空间复杂度： O(1) <br>
 * 是否稳定： 不稳定 <br>
 * 注：大顶堆概念：每个节点的值都大于或等于它的左右子节点的值，所以顶点的数就是最大值。
 * @Date: 2020/9/24 下午11:14 <br>
 * @Author: zxb <br>
 * @Version: 1.0 <br>
 */
public class HeapSort extends BaseSort {

  public static void main(String[] args) {
    HeapSort sort = new HeapSort();
    sort.printNums();
  }

  @Override
  protected void sort(int[] arr) {
    if (arr == null || arr.length < 2) {
      System.err.println("数组长度不可小于2");
      return;
    }
    // 构建大顶堆
    createTopHeap(arr);

    int length = arr.length;
    while (length > 1) {
      // 大顶堆交换头尾值，固定最大值在末尾
      swap(arr, 0, length - 1);
      // 末尾的索引值往左减一
      length--;
      // 重新构建大顶堆
      updateTopHeap(arr, length);
    }
  }

  /**
   * 首次创建一个大顶堆
   *
   * @param nums 数组
   */
  private void createTopHeap(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      // 当前插入的索引
      int cIdx = i;
      // 父节点的索引
      int pIdx = (cIdx - 1) / 2;

      // 如果当前遍历的值比父节点大的话，就交换值。然后继续往上层比较
      while (nums[cIdx] > nums[pIdx]) {
        // 交换当前遍历的值与父节点的值
        swap(nums, cIdx, pIdx);
        // 把父节点的索引指向当前遍历的索引
        cIdx = pIdx;
        // 往上计算父节点索引
        pIdx = (cIdx - 1) / 2;
      }
    }
  }

  /**
   * 重新构建大顶堆
   *
   * @param nums   被破坏的大顶堆
   * @param length 长度
   */
  private void updateTopHeap(int[] nums, int length) {
    // 当前节点索引
    int idx = 0;
    // 左节点索引
    int leftIdx = 2 * idx + 1;
    // 右节点索引
    int rightIdx = 2 * idx + 2;
    while (leftIdx < length) {
      // 最大值的索引
      int largest;
      // 如果右节点大于左节点，则最大索引指向右节点
      if (nums[rightIdx] > nums[leftIdx]) {
        largest = rightIdx;
      } else {
        largest = leftIdx;
      }
      // 如果父节点大于最大值，则把父节点索引指向最大值
      if (nums[idx] > nums[largest]) {
        largest = idx;
      }
      // 如果父节点指向最大值，证明已是大顶堆，退出循环
      if (idx == largest) {
        break;
      }
      // 如果不是大顶堆则交换父节点
      swap(nums, idx, largest);
      // 把最大值的索引变成父节点
      idx = largest;
      // 重新计算左节点索引
      leftIdx = 2 * idx + 1;
      // 重新计算右节点索引
      rightIdx = 2 * idx + 2;
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
