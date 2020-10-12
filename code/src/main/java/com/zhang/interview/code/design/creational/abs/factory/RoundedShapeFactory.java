package com.zhang.interview.code.design.creational.abs.factory;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: RoundedShapeFactory
 * @Author: zxb
 * @Date: 2020/10/12 10:05
 * @Description: 抽象工厂模式-工厂类
 */
public class RoundedShapeFactory extends AbstractFactory {

  @Override
  Shape getShape(String shapeType) {
    if (shapeType == null) {
      return null;
    }
    if (shapeType.equalsIgnoreCase("RECTANGLE")) {
      return new RoundedRectangle();
    } else if (shapeType.equalsIgnoreCase("SQUARE")) {
      return new RoundedSquare();
    }
    return null;
  }
}
