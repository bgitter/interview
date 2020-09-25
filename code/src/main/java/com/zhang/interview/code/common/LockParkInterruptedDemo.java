package com.zhang.interview.code.common;

import java.util.concurrent.locks.LockSupport;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: LockParkInterruptedDemo
 * @Author: zxb
 * @Date: 2020/9/25 14:36
 * @Description: 演示Park遇到interrupted发生什么
 */
public class LockParkInterruptedDemo {

  public static void main(String[] args) throws InterruptedException {
    Thread t = new Thread(() -> {
      int i = 0;
      while (true) {
        if (i == 0) {
          // 获取中断标记，但是不复位
          LockSupport.park();
          System.out.println(Thread.currentThread().isInterrupted());
          LockSupport.park();
          LockSupport.park();
          System.out.println("如果走到这里就说明park不生效了");
        }
        i++;
        if (i == Integer.MAX_VALUE) {
          break;
        }
      }
    });
    t.start();
    // 确保t被park()之后再中断
    Thread.sleep(1000);
    t.interrupt();
    System.out.println("end");
  }

}
