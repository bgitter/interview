package com.zhang.interview.code.design.structural.bridge;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: GreenCircle
 * @Author: zxb
 * @Date: 2020/10/12 15:21
 * @Description: 桥接模式-实现类
 */
public class GreenCircle implements DrawAPI {

  @Override
  public void drawCircle(int radius, int x, int y) {
    System.out.println(
        "Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", y: " + y + "]");
  }
}
