package com.zhang.interview.code.design.creational.abs.factory;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Square
 * @Author: zxb
 * @Date: 2020/10/12 9:46
 * @Description: 抽象工厂模式-实现类
 */
public class RoundedSquare implements Shape {

  @Override
  public void draw() {
    System.out.println("Inside RoundedSquare::draw() method.");
  }
}
