package com.zhang.interview.code.design.structural.bridge;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Circle
 * @Author: zxb
 * @Date: 2020/10/12 15:22
 * @Description: 桥接模式-实现类
 */
public class Circle extends Shape {

  private int x, y, radius;

  public Circle(int x, int y, int radius, DrawAPI drawAPI) {
    super(drawAPI);
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  @Override
  public void draw() {
    drawAPI.drawCircle(this.radius, this.x, this.y);
  }
}
