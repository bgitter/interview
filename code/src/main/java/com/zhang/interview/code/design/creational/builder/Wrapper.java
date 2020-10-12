package com.zhang.interview.code.design.creational.builder;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Wrapper
 * @Author: zxb
 * @Date: 2020/10/12 11:38
 * @Description: 构建者模式-打包类
 */
public class Wrapper implements Packing {

  @Override
  public String pack() {
    return "Wrapper";
  }
}
