package com.zhang.interview.code.sort.bubble;

import com.zhang.interview.code.sort.BaseSort;

/**
 * @ClassName: BubbleSort <br>
 * @Description: 冒泡排序： <br>
 * 1.比较相邻的元素。如果第一个比第二个大，就交换它们两个； <br>
 * 2.对每一对相邻的元素做同样的工作，从开始第一对到最后一对，这样在最后的元素就是最大的数； <br>
 * 3.排除最大的数，接着下一轮继续相同的操作，确定第二大的数...； <br>
 * 4.重复步骤1-3，直到排序完成。 <br>
 * <p>
 * 时间复杂度: O(n^2) <br>
 * 空间复杂度: O(1) <br>
 * 是否稳定: 稳定 <br>
 * @Date: 2020/9/23 上午12:01 <br>
 * @Author: zxb <br>
 * @Version: 1.0 <br>
 */
public class BubbleSort extends BaseSort {

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        sort.printNums();
    }

    @Override
    protected void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.err.println("数组长度不可小于2");
            return;
        }
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
