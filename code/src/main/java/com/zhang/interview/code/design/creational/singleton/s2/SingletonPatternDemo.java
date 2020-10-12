package com.zhang.interview.code.design.creational.singleton.s2;


/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: SingletonPatternDemo
 * @Author: zxb
 * @Date: 2020/10/12 10:44
 * @Description: 单例模式-入口 静态内部类 饿汉模式
 */
public class SingletonPatternDemo {

  public static void main(String[] args) {
    // get the only object available
    SingleObject object = SingleObject.getInstance();
    // show the message
    object.showMessage();
  }

}
