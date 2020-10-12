package com.zhang.interview.code.design.creational.builder;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ColdDrink
 * @Author: zxb
 * @Date: 2020/10/12 13:53
 * @Description: 构建者模式-冷饮
 */
public abstract class ColdDrink implements Item {

  @Override
  public Packing packing() {
    return new Bottle();
  }

  /**
   * @return
   */
  @Override
  public abstract float price();
}
