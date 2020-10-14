package com.zhang.interview.code.design.servlet.biz;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Client
 * @Author: zxb
 * @Date: 2020/10/14 17:59
 * @Description: BusinessDelegate模式
 */
public class Client {

  BusinessDelegate delegate;

  public Client(BusinessDelegate delegate) {
    this.delegate = delegate;
  }

  public void doTask() {
    delegate.doTask();
  }
}
