package com.zhang.interview.code.design.creational.builder;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Item
 * @Author: zxb
 * @Date: 2020/10/12 11:35
 * @Description: 构建者模式
 */
public interface Item {

  /**
   * name
   *
   * @return
   */
  String name();

  /**
   * 打包
   *
   * @return
   */
  Packing packing();

  /**
   * 价格
   *
   * @return
   */
  float price();

}
