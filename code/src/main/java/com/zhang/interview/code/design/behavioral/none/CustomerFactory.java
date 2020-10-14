package com.zhang.interview.code.design.behavioral.none;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: CustomerFactory
 * @Author: zxb
 * @Date: 2020/10/14 15:27
 * @Description: 空对象模式-工厂类
 */
public class CustomerFactory {

  public static final String[] names = {"Rob", "Joe", "Julie"};

  public static AbstractCustomer getCustomer(String name) {
    for (int i = 0; i < names.length; i++) {
      if (names[i].equalsIgnoreCase(name)) {
        return new RealCustomer(name);
      }
    }
    return new NullCustomer();
  }

}
