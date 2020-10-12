package com.zhang.interview.code.design.creational.prototype;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: PrototypePatternDemo
 * @Author: zxb
 * @Date: 2020/10/12 14:22
 * @Description: 原型模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/prototype_pattern.htm
 */
public class PrototypePatternDemo {

  public static void main(String[] args) {
    ShapeCache.loadCache();

    Shape clonedShape = ShapeCache.getShape("1");
    System.out.println("Shape: " + clonedShape.getType());

    clonedShape = ShapeCache.getShape("2");
    System.out.println("Shape: " + clonedShape.getType());

    clonedShape = ShapeCache.getShape("3");
    System.out.println("Shape: " + clonedShape.getType());
  }

}
