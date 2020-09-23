package com.zxb.code.sort.insert;

import com.zxb.code.sort.BaseSort;

/**
 * @ClassName: InsertSort <br>
 * @Description: 插入排序： <br>
 * 1.从第一个元素开始，该元素可以认为已经排序； <br>
 * 2.取出下一个元素，在前面已排序的元素中，从后向前扫描； <br>
 * 3.如果该元素（已排序）大于新元素，将该元素移到下一位； <br>
 * 4.重复步骤3，直到找到已排序的元素小于或等于新元素的位置； <br>
 * 5.将元素插入到该位置后； <br>
 * 6.重复2~5步骤。 <br>
 * <p>
 * 时间复杂度： O(n^2) <br>
 * 空间复杂度： O(1) <br>
 * 是否稳定： 稳定 <br>
 * @Date: 2020/9/23 上午7:06 <br>
 * @Author: zxb <br>
 * @Version: 1.0 <br>
 */
public class InsertSort extends BaseSort {

    public static void main(String[] args) {
        InsertSort sort = new InsertSort();
        sort.printNums();
    }

    protected void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.err.println("数组长度不可小于2");
            return;
        }
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            // 当前元素
            int c = arr[i + 1];
            // 前一个对象下标
            int preIdx = i;
            // 在数组中找到一个比当前遍历的数小的元素
            while (preIdx >= 0 && c < arr[preIdx]) {
                // 把比当前遍历的数大的元素往后移动一位
                arr[preIdx + 1] = arr[preIdx];
                // 需要插入的数的下标往前移动
                preIdx -= 1;
            }

            arr[preIdx + 1] = c;
        }
    }
}
