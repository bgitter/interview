package com.zhang.interview.code.design.creational.factory;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Square
 * @Author: zxb
 * @Date: 2020/10/12 9:46
 * @Description: 工厂模式-实现类
 */
public class Square implements Shape {

  @Override
  public void draw() {
    System.out.println("Inside Square::draw() method.");
  }
}
