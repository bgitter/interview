package com.zhang.interview.code.design.creational.singleton.s3;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: LazySingletonUnsafe
 * @Author: zxb
 * @Date: 2020/10/12 10:46
 * @Description: 单例模式-懒汉单例，线程不安全
 */
public class LazySingletonUnsafe {

  private static LazySingletonUnsafe instance = null;

  private LazySingletonUnsafe() {
  }

  public static LazySingletonUnsafe getInstance() {
    if (instance == null) {
      instance = new LazySingletonUnsafe();
    }
    return instance;
  }

  public void showMessage() {
    System.out.println("Hello World!");
  }
}
