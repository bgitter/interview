package com.zhang.interview.code.design.servlet.biz;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: BusinessDelegatePatternDemo
 * @Author: zxb
 * @Date: 2020/10/14 18:00
 * @Description: BusinessDelegate模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/business_delegate_pattern.htm
 */
public class BusinessDelegatePatternDemo {

  public static void main(String[] args) {
    BusinessDelegate delegate = new BusinessDelegate();
    delegate.setServiceType("EJB");

    Client client = new Client(delegate);
    client.doTask();

    delegate.setServiceType("JMS");
    client.doTask();
  }

}
