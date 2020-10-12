package com.zhang.interview.code.design.creational.abs.factory;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: AbstractFactoryPatternDemo
 * @Author: zxb
 * @Date: 2020/10/12 10:08
 * @Description: 抽象工厂模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/abstract_factory_pattern.htm
 */
public class AbstractFactoryPatternDemo {

  public static void main(String[] args) {
    // get shape factory
    AbstractFactory abstractFactory = FactoryProducer.getFactory(false);

    // get an object of Shape Rectangle
    Shape rectangle = abstractFactory.getShape("rectangle");
    rectangle.draw();
    // get an object of Shape Square
    Shape square = abstractFactory.getShape("square");
    square.draw();

    // get shape factory
    abstractFactory = FactoryProducer.getFactory(true);

    // get an object of Shape Rectangle
    Shape roundedRectangle = abstractFactory.getShape("rectangle");
    roundedRectangle.draw();
    // get an object of Shape Square
    Shape roundedSquare = abstractFactory.getShape("square");
    roundedSquare.draw();
  }

}
