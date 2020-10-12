package com.zhang.interview.code.design.creational.prototype;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Square
 * @Author: zxb
 * @Date: 2020/10/12 14:16
 * @Description: 原型模式-实现类
 */
public class Square extends Shape {

  public Square() {
    type = "Square";
  }

  @Override
  void draw() {
    System.out.println("Inside Square::draw() method.");
  }
}
