package com.zhang.interview.code.common;

import org.apache.commons.lang3.time.StopWatch;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: TopKDemo <br>
 * @Description: TopKDemo <br>
 * @Date: 2020/10/21 下午8:37 <br>
 * @Author: zxb <br>
 * @Version: 1.0 <br>
 * @Description: 题目描述：大量数据中找出最大的前N个数
 * 解题思路：最容易想到的方法是将数据全部排序，然后在排序后的集合中进行查找，最快的排序算法的时间复杂度一般为
 * O(nlogn)，如快排序。在海量的数据面前，计算机可用内存显然不可能一次性将全部数据读入内存进行排序的。其实即使
 * 内存能够满足要求，该方法也并不高效，因为题目是只需要找出前N个数（比如：N=10），而排序却是将所有的元素都排序
 * 了，做了很多无用功。
 * 可以采用最小堆方式处理。首先读入前N（以下N表示10）个数来创建大小为10的最小堆，然后遍历后续的数字，并于堆顶
 * （最小）数字进行比较。如果比最小的数小，则继续读取后续数字；如果比堆顶数字大，则替换堆顶元素并重新调整堆为最
 * 小堆。整个过程直至所有的数全部遍历完为止。然后按照中序遍历的方式输出当前堆中的所有10个数字。这个方式使用的内
 * 存是可控的，只有10个数字所需的内存即可。
 */
public class TopKDemo {

    /**
     * 存放海量的模拟数据
     */
    private static final File file = new File("topk_data.txt");
    private static final Random random = new Random();
    private static final int K = 10;
    private static final PriorityQueue<Long> priorityQueue = new PriorityQueue<>(K);
    private static final int NUM = 1000000;

    public static void init() {
        StopWatch watch = StopWatch.createStarted();
        try (FileWriter writer = new FileWriter(file, true)) {
            // 模拟NUM个数，一般100W个即可
            for (int i = 0; i < NUM; i++) {
                writer.write(String.valueOf(random.nextLong()) + System.lineSeparator());
            }
            // 写入10个接近long的最大的数，便于验证正确结果
            for (int i = 0; i < 10; i++) {
                writer.write(String.valueOf(Long.MAX_VALUE - i) + System.lineSeparator());
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("数据初始化耗时：" + watch.getTime(TimeUnit.MILLISECONDS) + "ms");
    }

    public static void main(String[] args) {
        if (!file.exists()) {
            init();
        }
        StopWatch watch = StopWatch.createStarted();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                long item = Long.parseLong(line);
                if (priorityQueue.size() < K) {
                    priorityQueue.add(item);
                } else {
                    long head = priorityQueue.peek();
                    if (item > head) {
                        // 将首个元素从队列内拉取
                        priorityQueue.poll();
                        // 将当前元素插入队列中
                        priorityQueue.add(item);
                    }
                }
            }
            System.out.println("查找最大前N个数耗时： " + watch.getTime(TimeUnit.MILLISECONDS) + "ms");
            Long item = null;
            while ((item = priorityQueue.poll()) != null) {
                System.out.println("item: " + item);
            }
            System.out.println("Long.MAX_VALUE: " + Long.MAX_VALUE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
