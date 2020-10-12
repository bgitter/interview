package com.zhang.interview.code.design.creational.abs.factory;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: FactoryProducer
 * @Author: zxb
 * @Date: 2020/10/12 10:06
 * @Description: 抽象工厂模式-生成工厂类
 */
public class FactoryProducer {

  /**
   * 获取工厂类
   *
   * @param rounded rounded
   * @return factory object
   */
  public static AbstractFactory getFactory(boolean rounded) {
    if (rounded) {
      return new RoundedShapeFactory();
    } else {
      return new ShapeFactory();
    }
  }

}
