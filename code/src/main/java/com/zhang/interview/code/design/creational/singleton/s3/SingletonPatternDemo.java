package com.zhang.interview.code.design.creational.singleton.s3;


/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: SingletonPatternDemo
 * @Author: zxb
 * @Date: 2020/10/12 10:44
 * @Description: 单例模式-入口 懒汉模式 线程不安全
 */
public class SingletonPatternDemo {

  public static void main(String[] args) {
    // get the only object available
    LazySingletonUnsafe object = LazySingletonUnsafe.getInstance();
    // show the message
    object.showMessage();
  }

}
