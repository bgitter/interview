package com.zxb.code.sort.shell;

import com.zxb.code.sort.BaseSort;

/**
 * @ClassName: ShellSort <br>
 * @Description: 希尔排序： <br>
 * 1.把数组分割成若干（h）个小组（一般数组长度 length/2）； <br>
 * 2.然后把每一个小组分别执行插入排序； <br>
 * 3.每一轮分割的数组个数逐步缩小，h=h/2 > h/4 > h/8 > 1，并且进行排序，保证有序； <br>
 * 4.当 h=1 时，则排序完成。 <br>
 * <p>
 * 时间复杂度： O(n*log2n) <br>
 * 空间复杂度： O(1) <br>
 * 是否稳定： 稳定 <br>
 * @Date: 2020/9/24 上午6:24 <br>
 * @Author: zxb <br>
 * @Version: 1.0 <br>
 */
public class ShellSort extends BaseSort {

    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        sort.printNums();
    }

    protected void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.err.println("数组长度不可小于2");
            return;
        }
        int length = arr.length;
        int temp;
        // 步长
        int gap = length / 2;
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                temp = arr[i];
                int preIdx = i - gap;
                while (preIdx >= 0 && arr[preIdx] > temp) {
                    arr[preIdx + gap] = arr[preIdx];
                    preIdx -= gap;
                }
                arr[preIdx + gap] = temp;
            }
            gap /= 2;
        }
    }
}
