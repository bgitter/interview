package com.zhang.interview.code.design.behavioral.none;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: NullCustomer
 * @Author: zxb
 * @Date: 2020/10/14 15:26
 * @Description: 空对象模式-空类
 */
public class NullCustomer extends AbstractCustomer {

  @Override
  public boolean isNil() {
    return true;
  }

  @Override
  public String getName() {
    return "Not Available in Customer Database";
  }
}
