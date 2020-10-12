package com.zhang.interview.code.design.creational.builder;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: VegBurger
 * @Author: zxb
 * @Date: 2020/10/12 13:55
 * @Description: 构建者模式-蔬菜汉堡
 */
public class VegBurger extends Burger {

  @Override
  public String name() {
    return "Veg Burger";
  }

  @Override
  public float price() {
    return 25.0F;
  }
}
