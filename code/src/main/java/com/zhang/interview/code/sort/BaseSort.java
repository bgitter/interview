package com.zhang.interview.code.sort;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @className: BaseSort <br>
 * @description: BaseSort <br>
 * @date: 2020/9/22 下午11:27 <br>
 * @author: zxb <br>
 * @version: 1.0 <br>
 */
public abstract class BaseSort {
    /**
     * 排序数组长度
     */
    protected static int length = 100000;

    /**
     * 打印数组
     */
    public void printNums() {
        printNums(length);
    }

    /**
     * 打印数组
     *
     * @param arrayLength 指定数组长度
     */
    public void printNums(int arrayLength) {
        int[] nums = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            int num = random.nextInt(1000) + 1;
            nums[i] = num;
        }
        System.out.println("排序前：" + Arrays.toString(nums));
        StopWatch watch = StopWatch.createStarted();
        sort(nums);
        System.out.println("排序后:" + Arrays.toString(nums));
        System.out.println(String.format("耗时：%dms", watch.getTime(TimeUnit.MILLISECONDS)));
    }

    /**
     * 执行排序
     *
     * @param arr 参数
     */
    protected abstract void sort(int[] arr);

}
