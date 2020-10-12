package com.zhang.interview.code.design.structural.bridge;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Shape
 * @Author: zxb
 * @Date: 2020/10/12 15:18
 * @Description: 桥接模式-抽象类
 */
public abstract class Shape {

  protected DrawAPI drawAPI;

  protected Shape(DrawAPI api) {
    this.drawAPI = api;
  }

  /**
   * draw
   */
  public abstract void draw();
}
