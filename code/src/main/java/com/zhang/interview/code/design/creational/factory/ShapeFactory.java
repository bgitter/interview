package com.zhang.interview.code.design.creational.factory;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ShapeFactory
 * @Author: zxb
 * @Date: 2020/10/12 9:47
 * @Description: 工厂模式-工厂类
 */
public class ShapeFactory {

  /**
   * use getShape method to get object of type shape
   *
   * @param shapeType type
   * @return shape object
   */
  public Shape getShape(String shapeType) {
    if (shapeType == null) {
      return null;
    }
    if (shapeType.equalsIgnoreCase("CIRCLE")) {
      return new Circle();
    } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
      return new Rectangle();
    } else if (shapeType.equalsIgnoreCase("SQUARE")) {
      return new Square();
    }
    return null;
  }

}
