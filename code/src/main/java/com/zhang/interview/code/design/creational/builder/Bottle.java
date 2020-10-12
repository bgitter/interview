package com.zhang.interview.code.design.creational.builder;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Bottle
 * @Author: zxb
 * @Date: 2020/10/12 11:39
 * @Description: 构建者模式-装瓶类
 */
public class Bottle implements Packing {

  @Override
  public String pack() {
    return "Bottle";
  }
}
