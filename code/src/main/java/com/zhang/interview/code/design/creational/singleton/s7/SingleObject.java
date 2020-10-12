package com.zhang.interview.code.design.creational.singleton.s7;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: SingleObject
 * @Author: zxb
 * @Date: 2020/10/12 10:15
 * @Description: 单例模式-单例对象 饿汉模式 防止反射破坏单例
 */
public class SingleObject {

  /**
   * create an object of SingleObject
   */
  private static final SingleObject instance;

  static {
    instance = new SingleObject();
  }

  /**
   * make the constructor private so that this class cannot be instantiated
   */
  private SingleObject() {
    if (instance != null) {
      throw new RuntimeException("单例模式禁止反射调用");
    }
  }

  public static SingleObject getInstance() {
    return instance;
  }

  public void showMessage() {
    System.out.println("Hello World!");
  }
}
