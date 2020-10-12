package com.zhang.interview.code.design.creational.prototype;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Circle
 * @Author: zxb
 * @Date: 2020/10/12 14:17
 * @Description: 原型模式-实现类
 */
public class Circle extends Shape {

  public Circle() {
    type = "Circle";
  }

  @Override
  void draw() {
    System.out.println("Inside Circle::draw() method.");
  }
}
