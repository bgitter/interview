package com.zhang.interview.code.design.structural.flyweight;

import java.util.HashMap;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ShapeFactory
 * @Author: zxb
 * @Date: 2020/10/13 16:39
 * @Description: 享元模式-工厂类
 */
public class ShapeFactory {

  private static final HashMap<String, Circle> cache = new HashMap<>();

  public static Circle getCircle(String color) {
    Circle circle = cache.get(color);
    if (circle == null) {
      circle = new Circle(color);
      cache.put(color, circle);
      System.out.println("Creating circle of color: " + color);
    }
    return circle;
  }

}
