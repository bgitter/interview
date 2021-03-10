package com.zhang.interview.code.sort.quick;

import com.zhang.interview.code.sort.BaseSort;

/**
 * @ClassName: QuickSort <br>
 * @Description: 快排序： <br>
 * 1.从数组中选一个数作为基数，一般选第一个数，或者最后一个数； <br>
 * 2.采用双指针（头尾两端）遍历，从左往右找到比基准数大的第一个数，从右往左找到比基准数小的第一个数，交换两数位置，
 * 直到头尾指针相等或头指针大于尾指针，把基准数与头指针的数交换，这样一轮过后，左边的数就比基准数小，右边的数就比
 * 基准数大； <br>
 * 3.对左边的数列，重复上面1～2步骤，对右边的数列重复1~2步骤； <br>
 * 4.左右两边数列递归结束后，排序完成。 <br>
 * <p>
 * 时间复杂度： O(nlogn)
 * 空间复杂度： O(1)
 * 是否稳定： 不稳定
 * <p>
 * 说明： 这是一种使用分治法的排序。 <br>
 * @Date: 2020/9/24 上午7:14 <br>
 * @Author: zxb <br>
 * @Version: 1.0 <br>
 */
public class QuickSort extends BaseSort {

  public static void main(String[] args) {
    QuickSort sort = new QuickSort();
    sort.printNums(100);
  }

  @Override
  protected void sort(int[] arr) {
    if (arr == null || arr.length < 2) {
      System.err.println("数组长度不可小于2");
      return;
    }
    quickSort(arr, 0, arr.length - 1);
  }

  private void quickSort(int[] arr, int left, int right) {
    if (left > right) {
      return;
    }
    int i = left;
    int j = right;
    // 选择基准数
    int key = arr[left];
    while (i < j) {
      // 注意：先从右边把小于或等于key的元素找到并移动前面
      // 从右往左找第一个小于或等于基准数的元素
      while (i < j && arr[j] > key) {
        j--;
      }
      // 从左往右找第一个大于基准数的元素
      while (i < j && arr[i] <= key) {
        i++;
      }

      if (i < j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    // 交换基准数与左指针值
    arr[left] = arr[i];
    arr[i] = key;
    // 将基准数两侧的数组继续使用递归的方式排序
    quickSort(arr, left, i - 1);
    quickSort(arr, i + 1, right);
  }
}
