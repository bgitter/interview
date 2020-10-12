package com.zhang.interview.code.design.creational.prototype;

import java.util.Hashtable;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ShapeCache
 * @Author: zxb
 * @Date: 2020/10/12 14:17
 * @Description: 原型模式-缓存
 */
public class ShapeCache {

  private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

  public static Shape getShape(String shapeId) {
    Shape cache = shapeMap.get(shapeId);
    return (Shape) cache.clone();
  }

  public static void loadCache() {
    Circle circle = new Circle();
    circle.setId("1");
    shapeMap.put(circle.getId(), circle);

    Square square = new Square();
    square.setId("2");
    shapeMap.put(square.getId(), square);

    Rectangle rectangle = new Rectangle();
    rectangle.setId("3");
    shapeMap.put(rectangle.getId(), rectangle);
  }
}
