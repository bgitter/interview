package com.zhang.interview.code.design.creational.factory;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Rectangle
 * @Author: zxb
 * @Date: 2020/10/12 9:45
 * @Description: 工厂模式-实现类
 */
public class Rectangle implements Shape {

  @Override
  public void draw() {
    System.out.println("Inside Rectangle::draw() method.");
  }
}
