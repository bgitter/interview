package com.zhang.interview.code.design.structural.flyweight;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Circle
 * @Author: zxb
 * @Date: 2020/10/13 16:38
 * @Description: 享元模式-实现类
 */
public class Circle implements Shape {

  private String color;
  private int x;
  private int y;
  private int radius;

  public Circle(String color) {
    this.color = color;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }

  @Override
  public void draw() {
    System.out.println(
        String.format("Circle::draw() [Color: %s, x: %d, y: %d, radius: %s", color, x, y, radius));
  }
}
