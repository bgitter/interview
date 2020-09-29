package com.zhang.interview.code.common;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ThreadPrintDemo
 * @Author: zxb
 * @Date: 2020/9/28 21:30
 * @Description: 多线程交替打印
 * 阿里面试：多线程交替打印字符串，如：ali，使用多线程交替打印如下格式：ali ali ali ali ...
 * 要求：一个线程打印a, 一个线程打印l, 一个线程打印i，一个线程打印空格，交替打印，支持扩展。比如
 * 打印次数，不同的字符串等
 */
public class ThreadPrintDemo {

  private String input;
  private int threadSize;
  private int printTimes;
  private int index = 0;
  private int read = 0;

  private CountDownLatch done = new CountDownLatch(1);

  /**
   * 打印构造函数
   *
   * @param input      待打印字符串
   * @param printTimes 打印次数
   * @param threadSize 线程任务数
   */
  public ThreadPrintDemo(String input, int printTimes, int threadSize) {
    this.input = input;
    this.printTimes = printTimes;
    this.threadSize = threadSize;
    read = threadSize;
  }

  /**
   * 打印入口
   */
  private void print() throws InterruptedException {
    if (input == null) {
      return;
    }
    StopWatch watch = StopWatch.createStarted();
    // 线程交替执行
    ExecutorService executorService = Executors.newFixedThreadPool(threadSize);
    for (int i = 0; i < threadSize; i++) {
      executorService.execute(() -> {
        try {
          run();
        } catch (Exception e) {
          e.printStackTrace();
        }
      });
    }
    done.await();
    System.out.println(String.format("耗时：%dms", watch.getTime(TimeUnit.MILLISECONDS)));
    executorService.shutdown();
  }

  /**
   * 打印
   */
  private void run() throws Exception {
    int length = input.length();
    String threadName = Thread.currentThread().getName();
    while (true) {
      /*System.out.println(threadName + ",进入同步块之前");*/

      synchronized (this) {
        // 任务已执行完毕，跳出循环
        if (done.getCount() == 0) {
          break;
        }

        if (index == length) {
          // 重置输出位，保证下次输出从字符串头部开始
          index = 0;
          System.out.println(threadName + ":" + " ");

          // 当打印次数不为负数时（为负值表示打印次数不限），完成一次完整的字符输出，打印次数减一
          printTimes = printTimes > 0 ? printTimes - 1 : printTimes;
          if (printTimes == 0) {
            done.countDown();
            // 通知其他阻塞线程
            System.out.println(threadName + ",通知其他线程执行完毕");
            notifyAll();
            break;
          }
        } else {
          System.out.println(threadName + ":" + input.charAt(index++));
        }
        read -= 1;
        if (read == 0) {
          read = threadSize;
          System.out.println("---------");
          notifyAll();
        } else {
          wait();
        }
      }
    }
    System.out.println(threadName + "执行完毕");
  }

  public static void main(String[] args) throws Exception {
    new ThreadPrintDemo("ali", 100000, 4).print();
  }
}
