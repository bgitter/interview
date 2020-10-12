package com.zhang.interview.code.design.creational.abs.factory;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: AbstractFactory
 * @Author: zxb
 * @Date: 2020/10/12 10:00
 * @Description: 抽象工厂模式-抽象工厂
 */
public abstract class AbstractFactory {

  /**
   * get an object of the shapeType
   *
   * @param shapeType shapeType
   * @return shape object
   */
  abstract Shape getShape(String shapeType);

}
