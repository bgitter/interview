package com.zhang.interview.code.design.structural.facade;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ShapeMaker
 * @Author: zxb
 * @Date: 2020/10/13 16:01
 * @Description: 外观模式-外观类
 */
public class ShapeMaker {

  private Shape circle;
  private Shape rectangle;
  private Shape square;

  public ShapeMaker() {
    circle = new Circle();
    rectangle = new Rectangle();
    square = new Square();
  }

  public void drawCircle() {
    circle.draw();
  }

  public void drawRectangle() {
    rectangle.draw();
  }

  public void drawSquare() {
    square.draw();
  }
}
