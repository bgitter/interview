package com.zhang.interview.code.design.structural.facade;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Circle
 * @Author: zxb
 * @Date: 2020/10/13 15:59
 * @Description: 外观模式-实现类
 */
public class Circle implements Shape {

  @Override
  public void draw() {
    System.out.println("Circle::draw()");
  }
}
