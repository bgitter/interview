package com.zhang.interview.code.design.creational.prototype;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Rectangle
 * @Author: zxb
 * @Date: 2020/10/12 14:14
 * @Description: 原型模式-实现类
 */
public class Rectangle extends Shape {

  public Rectangle() {
    type = "Rectangle";
  }

  @Override
  void draw() {
    System.out.println("Inside Rectangle::draw() method.");
  }
}
