package com.zhang.interview.code.sort.select;

import com.zhang.interview.code.sort.BaseSort;

/**
 * @ClassName: SelectSort <br>
 * @Description: 选择排序： <br>
 * 1.第一轮，找到最小的元素，和数组第一个位置交换； <br>
 * 2.第二轮，找到第二小的元素，和数组第二个位置交换； <br>
 * 3.直到最后一个元素，排序完成。 <br>
 * <p>
 * 时间复杂度： O(n^2) <br>
 * 空间复杂度： O(1) <br>
 * 是否稳定： 不稳定 <br>
 * @Date: 2020/9/23 上午7:07 <br>
 * @Author: zxb <br>
 * @Version: 1.0 <br>
 */
public class SelectSort extends BaseSort {

    public static void main(String[] args) {
        SelectSort sort = new SelectSort();
        sort.printNums();
    }

    protected void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.err.println("数组长度不可小于2");
            return;
        }
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int minIdx = i;
            // 找到最小元素
            for (int j = i + 1; j < length; j++) {
                if (arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }
            if (i != minIdx) {
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
            }
        }
    }
}
