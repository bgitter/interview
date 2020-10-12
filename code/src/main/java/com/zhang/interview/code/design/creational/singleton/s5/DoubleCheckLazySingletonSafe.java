package com.zhang.interview.code.design.creational.singleton.s5;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: DoubleCheckLazySingletonSafe
 * @Author: zxb
 * @Date: 2020/10/12 10:52
 * @Description: 单例模式-双重检查锁机制
 */
public class DoubleCheckLazySingletonSafe {

  /**
   * 使用volatile来禁止指令重排序
   */
  private static volatile DoubleCheckLazySingletonSafe instance = null;

  private DoubleCheckLazySingletonSafe() {
  }

  public static DoubleCheckLazySingletonSafe getInstance() {
    if (instance == null) {
      synchronized (DoubleCheckLazySingletonSafe.class) {
        if (instance == null) {
          instance = new DoubleCheckLazySingletonSafe();
        }
      }
    }
    return instance;
  }

  public void showMessage() {
    System.out.println("Hello World!");
  }
}
