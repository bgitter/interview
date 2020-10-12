package com.zhang.interview.code.design.creational.builder;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Pepsi
 * @Author: zxb
 * @Date: 2020/10/12 13:57
 * @Description: 构建者模式-百事可乐
 */
public class Pepsi extends ColdDrink {

  @Override
  public String name() {
    return "Pepsi";
  }

  @Override
  public float price() {
    return 35.0F;
  }
}
