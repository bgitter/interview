package com.zhang.interview.code.design.creational.singleton.s2;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: SingleObject
 * @Author: zxb
 * @Date: 2020/10/12 10:42
 * @Description: 单例模式-单例类
 */
public class SingleObject {

  private static class InnerClass {

    private static SingleObject instance = new SingleObject();
  }

  private SingleObject() {
  }

  /**
   * 获取单例
   *
   * @return object
   */
  public static SingleObject getInstance() {
    return InnerClass.instance;
  }

  public void showMessage() {
    System.out.println("Hello World!");
  }
}
