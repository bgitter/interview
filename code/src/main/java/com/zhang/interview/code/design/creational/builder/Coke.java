package com.zhang.interview.code.design.creational.builder;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Coke
 * @Author: zxb
 * @Date: 2020/10/12 13:56
 * @Description: 构建者模式-可口可乐
 */
public class Coke extends ColdDrink {

  @Override
  public String name() {
    return "Coke";
  }

  @Override
  public float price() {
    return 30.0F;
  }
}
