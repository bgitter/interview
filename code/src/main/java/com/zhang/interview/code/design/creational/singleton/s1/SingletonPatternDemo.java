package com.zhang.interview.code.design.creational.singleton.s1;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: SingletonPatternDemo
 * @Author: zxb
 * @Date: 2020/10/12 10:17
 * @Description: 单例模式-入口 饿汉模式
 * 示例代码：https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm
 */
public class SingletonPatternDemo {

  public static void main(String[] args) {
    // illegal construct
    // Compile Time Error: The Constructor SingleObject() is no visible
    // SingleObject object = new SingleObject();

    // get the only object available
    SingleObject object = SingleObject.getInstance();
    // show the message
    object.showMessage();
  }

}
