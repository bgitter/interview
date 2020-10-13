package com.zhang.interview.code.design.structural.facade;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Rectangle
 * @Author: zxb
 * @Date: 2020/10/13 16:00
 * @Description: 外观模式-实现类
 */
public class Rectangle implements Shape {

  @Override
  public void draw() {
    System.out.println("Rectangle::draw()");
  }
}
