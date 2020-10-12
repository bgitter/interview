package com.zhang.interview.code.design.creational.factory;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: FactoryPatternDemo
 * @Author: zxb
 * @Date: 2020/10/12 9:50
 * @Description: 工厂模式-入口
 * 示例地址：https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 */
public class FactoryPatternDemo {

  public static void main(String[] args) {
    ShapeFactory factory = new ShapeFactory();
    // get an object of Circle and call its draw method.
    Shape circle = factory.getShape("CIRCLE");
    circle.draw();

    // get an object of Rectangle and call its draw method.
    Shape rectangle = factory.getShape("RECTANGLE");
    rectangle.draw();

    // get an object of Square and call its draw method.
    Shape square = factory.getShape("SQUARE");
    square.draw();
  }

}
