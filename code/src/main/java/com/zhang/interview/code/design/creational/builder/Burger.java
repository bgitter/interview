package com.zhang.interview.code.design.creational.builder;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Burger
 * @Author: zxb
 * @Date: 2020/10/12 11:40
 * @Description: 构建者模式-汉堡
 */
public abstract class Burger implements Item {

  @Override
  public Packing packing() {
    return new Wrapper();
  }

  /**
   * @return
   */
  @Override
  public abstract float price();
}
