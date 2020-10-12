package com.zhang.interview.code.design.creational.builder;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ChickenBurger
 * @Author: zxb
 * @Date: 2020/10/12 13:56
 * @Description: 构建者模式-鸡肉汉堡
 */
public class ChickenBurger extends Burger {

  @Override
  public String name() {
    return "Chicken Burger";
  }

  @Override
  public float price() {
    return 50.5F;
  }
}
