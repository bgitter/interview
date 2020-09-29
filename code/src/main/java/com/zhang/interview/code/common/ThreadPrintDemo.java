package com.zhang.interview.code.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

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
  private AtomicInteger loop;
  private volatile boolean startup = true;
  private volatile int arrived = 0;
  private AtomicInteger idx = new AtomicInteger(0);

  /**
   * 打印构造函数
   *
   * @param input      待打印字符串
   * @param loop       打印次数
   * @param threadSize 线程任务数
   */
  public ThreadPrintDemo(String input, int loop, int threadSize) {
    this.input = input;
    this.loop = new AtomicInteger(loop);
    this.threadSize = threadSize;
  }

  /**
   * 打印入口
   */
  private void print() {
    if (input == null) {
      return;
    }
    // 线程交替执行
    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int i = 0; i < threadSize; i++) {
      executorService.execute(() -> {
        try {
          run();
        } catch (Exception e) {
          e.printStackTrace();
        }
      });
    }
    executorService.shutdown();
  }

  /**
   * 打印
   */
  private void run() throws Exception {
    int length = input.length();
    String threadName = Thread.currentThread().getName();
    // 获取执行资源且当前状态可执行
    while (startup) {
      // 获取同步锁
      synchronized (this) {
        if (!startup) {
          notifyAll();
          break;
        }

        if (idx.get() == length) {
          // 输出位重置
          idx.set(0);
          // 一次完成字符串输出，任务执行次数减一
          System.out.println(threadName + ":" + " ");
          if (loop.decrementAndGet() == 0) {
            // 输出换行
            System.out.println("");
            // 任务执行完毕
            startup = false;
            // 通知其他阻塞线程
            notifyAll();
          }
        } else {
          System.out.println(threadName + ":" + input.charAt(idx.getAndIncrement()));
        }

        arrived += 1;
        if (arrived == threadSize) {
          notifyAll();
          arrived = 0;
        } else {
          wait();
        }
      }
    }
    System.out.println(threadName + "执行完毕");
  }

  public static void main(String[] args) {
    new ThreadPrintDemo("ali", 10, 4).print();
  }
}
