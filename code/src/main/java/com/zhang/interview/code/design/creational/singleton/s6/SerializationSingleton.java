package com.zhang.interview.code.design.creational.singleton.s6;

import java.io.Serializable;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: SerializationSingleton
 * @Author: zxb
 * @Date: 2020/10/12 11:00
 * @Description: 单例模式-单例序列化
 */
public class SerializationSingleton implements Serializable {


  private static final long serialVersionUID = 1475938790364939695L;
  /**
   * 使用volatile来禁止指令重排序
   */
  private static volatile SerializationSingleton instance = null;

  private SerializationSingleton() {
  }

  public static SerializationSingleton getInstance() {
    if (instance == null) {
      synchronized (SerializationSingleton.class) {
        if (instance == null) {
          instance = new SerializationSingleton();
        }
      }
    }
    return instance;
  }

  /**
   * 解决反序列化时的破坏
   *
   * @return instance
   */
  private Object readResolve() {
    return instance;
  }

  public void showMessage() {
    System.out.println("Hello World!");
  }

}
