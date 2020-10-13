package com.zhang.interview.code.design.structural.flyweight;

import org.apache.commons.lang3.RandomUtils;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: FlyWeightPatternDemo
 * @Author: zxb
 * @Date: 2020/10/13 16:40
 * @Description: 享元模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/flyweight_pattern.htm
 */
public class FlyWeightPatternDemo {

  private static final String[] colors = {"Red", "Green", "Blue", "White", "Black"};

  public static void main(String[] args) {
    for (int i = 0; i < 20; i++) {
      Circle circle = ShapeFactory.getCircle(getRandomColor());
      circle.setX(getRandomX());
      circle.setY(getRandomY());
      circle.setRadius(100);
      circle.draw();
    }
  }

  private static String getRandomColor() {
    return colors[(int) (Math.random() * colors.length)];
  }

  private static int getRandomX() {
    return RandomUtils.nextInt(0, 100);
  }

  private static int getRandomY() {
    return RandomUtils.nextInt(0, 100);
  }
}
