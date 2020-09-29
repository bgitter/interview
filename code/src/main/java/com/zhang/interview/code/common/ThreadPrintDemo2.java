package com.zhang.interview.code.common;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ThreadPrintDemo2
 * @Author: zxb
 * @Date: 2020/9/29 13:55
 * @Description: 交替打印示例2
 */
public class ThreadPrintDemo2 {

  String input;
  int printTimes;
  int threadSize;

  int idx = 0;
  private CountDownLatch done = new CountDownLatch(1);
  private CyclicBarrier cyclicBarrier;

  public ThreadPrintDemo2(String input, int printTimes, int threadSize) {
    this.input = input;
    this.printTimes = printTimes;
    this.threadSize = threadSize;
    this.cyclicBarrier = new CyclicBarrier(this.threadSize,
        () -> System.out.println("---- 美丽的分割线 ----"));
  }

  private void print() throws Exception {
    if (input == null) {
      return;
    }
    StopWatch watch = StopWatch.createStarted();
    ExecutorService executorService = Executors.newFixedThreadPool(this.threadSize);
    for (int i = 0; i < this.threadSize; i++) {
      executorService.execute(() -> {
        run();
      });
    }
    done.await();
    System.out.println(String.format("耗时：%dms", watch.getTime(TimeUnit.MILLISECONDS)));
    executorService.shutdown();
  }

  private void run() {
    try {
      String threadName = Thread.currentThread().getName();
      int length = this.input.length();
      while (true) {
        synchronized (this) {
          if (done.getCount() == 0) {
            break;
          }
          if (idx == length) {
            System.out.println(threadName + ": ");
            printTimes = printTimes > 0 ? printTimes - 1 : printTimes;
            if (printTimes == 0) {
              done.countDown();
            }
            idx = 0;
          } else {
            System.out.println(threadName + ": " + this.input.charAt(idx++));
          }
        }
        this.cyclicBarrier.await();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws Exception {
    new ThreadPrintDemo2("alibaba", 100000, 5).print();
  }
}
