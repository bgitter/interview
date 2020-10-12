package com.zhang.interview.code.design.creational.singleton.s1;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: SingleObject
 * @Author: zxb
 * @Date: 2020/10/12 10:15
 * @Description: 单例模式-单例对象
 */
public class SingleObject {

  /**
   * create an object of SingleObject
   */
  private static SingleObject instance = new SingleObject();

  /**
   * make the constructor private so that this class cannot be instantiated
   */
  private SingleObject() {
  }

  public static SingleObject getInstance() {
    return instance;
  }

  public void showMessage() {
    System.out.println("Hello World!");
  }
}
