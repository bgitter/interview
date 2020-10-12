package com.zhang.interview.code.design.creational.singleton.s4;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: LazySingleton
 * @Author: zxb
 * @Date: 2020/10/12 10:46
 * @Description: 单例模式-懒汉单例，线程同步，性能问题
 */
public class LazySingleton {

  private static LazySingleton instance = null;

  private LazySingleton() {
  }

  public synchronized static LazySingleton getInstance() {
    if (instance == null) {
      instance = new LazySingleton();
    }
    return instance;
  }

  public void showMessage() {
    System.out.println("Hello World!");
  }
}
