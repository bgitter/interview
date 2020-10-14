package com.zhang.interview.code.design.behavioral.none;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: RealCustomer
 * @Author: zxb
 * @Date: 2020/10/14 15:25
 * @Description: 空对象模式-实现类
 */
public class RealCustomer extends AbstractCustomer {

  public RealCustomer(String name) {
    this.name = name;
  }

  @Override
  public boolean isNil() {
    return false;
  }

  @Override
  public String getName() {
    return name;
  }
}
