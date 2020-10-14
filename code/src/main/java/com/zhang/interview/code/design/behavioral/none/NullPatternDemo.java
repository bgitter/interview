package com.zhang.interview.code.design.behavioral.none;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: NullPatternDemo
 * @Author: zxb
 * @Date: 2020/10/14 15:29
 * @Description: 空对象模式-入口
 */
public class NullPatternDemo {

  public static void main(String[] args) {
    AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
    AbstractCustomer customer2 = CustomerFactory.getCustomer("Bob");
    AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
    AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");

    System.out.println("Customers");
    System.out.println(customer1.getName());
    System.out.println(customer2.getName());
    System.out.println(customer3.getName());
    System.out.println(customer4.getName());
  }

}
