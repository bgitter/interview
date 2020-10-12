package com.zhang.interview.code.design.structural.decorator;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Rectangle
 * @Author: zxb
 * @Date: 2020/10/12 16:18
 * @Description: 装饰者模式-实现类
 */
public class Rectangle implements Shape {

  @Override
  public void draw() {
    System.out.println("Shape: Rectangle");
  }
}
