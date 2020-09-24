package com.zhang.interview.code.sort.merge;

import com.zhang.interview.code.sort.BaseSort;

/**
 * @ClassName: MergeSort <br>
 * @Description: 归并排序： <br>
 * 1.把数组不断划分成子序列，化成长度为2或1的子序列； <br>
 * 2.然后利用临时数组，对子序列进行排序，合并，再把临时数组复制回原数组； <br>
 * 3.重复1~2步骤，直到排序完成。 <br>
 * <p>
 * 时间复杂度： O(nlogn) <br>
 * 空间复杂度： O(n) <br>
 * 是否稳定： 稳定 <br>
 * 注意：归并排序是采用分治法的典型应用，而且是一种稳定的排序方式，不过需要使用到额外空间。
 * 优点在于最好和最坏的情况时间复杂度都是O(nlogn)，所以是比较稳定的排序方式。
 * @Date: 2020/9/24 下午10:34 <br>
 * @Author: zxb <br>
 * @Version: 1.0 <br>
 */
public class MergeSort extends BaseSort {

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        sort.printNums();
    }

    protected void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.err.println("数组长度不可小于2");
            return;
        }
        mergeSort(0, arr.length - 1, arr, new int[arr.length]);
    }

    /**
     * 从数组内分解子序列并执行排序
     *
     * @param start 开始下标
     * @param end   结束下标
     * @param nums  原数组
     * @param temp  临时数组
     */
    private void mergeSort(int start, int end, int[] nums, int[] temp) {
        // 起始位置与终止位置一致，终止递归拆解
        if (start >= end) {
            return;
        }
        // 计算中间位置
        int mid = start + (end - start) / 2;

        // 递归拆解左侧数组
        mergeSort(start, mid, nums, temp);
        // 递归拆机右侧数组
        mergeSort(mid + 1, end, nums, temp);

        // 子序列排序，合并
        merge(start, end, mid, nums, temp);
    }

    /**
     * 子序列排序、合并；临时数组复制回原数组
     *
     * @param start 开始位置
     * @param end   结束位置
     * @param mid   中间位置
     * @param nums  数组
     * @param temp  临时数组
     */
    private void merge(int start, int end, int mid, int[] nums, int[] temp) {
        int idx = 0;
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (nums[i] > nums[j]) {
                temp[idx++] = nums[j++];
            } else {
                temp[idx++] = nums[i++];
            }
        }
        // 遍历剩余i节点到中间节点的元素
        while (i <= mid) {
            temp[idx++] = nums[i++];
        }
        // 遍历剩余j节点到结束节点的元素
        while (j <= end) {
            temp[idx++] = nums[j++];
        }
        // 把临时数组中已排序的数复制到nums数组中
        if (idx > 0) {
            System.arraycopy(temp, 0, nums, start, idx);
        }
    }
}
