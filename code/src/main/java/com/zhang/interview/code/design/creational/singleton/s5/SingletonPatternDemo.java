package com.zhang.interview.code.design.creational.singleton.s5;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: SingletonPatternDemo
 * @Author: zxb
 * @Date: 2020/10/12 10:44
 * @Description: 单例模式-入口 懒汉模式 双重检查锁机制
 * 示例代码：https://github.com/heibaiying/Full-Stack-Notes/blob/master/notes/Java_%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F.md#1-%E5%8D%95%E4%BE%8B%E6%A8%A1%E5%BC%8F
 */
public class SingletonPatternDemo {

  public static void main(String[] args) {
    // get the only object available
    DoubleCheckLazySingletonSafe object = DoubleCheckLazySingletonSafe.getInstance();
    // show the message
    object.showMessage();
  }

}
