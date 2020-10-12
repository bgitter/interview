package com.zhang.interview.code.design.structural.decorator;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: DecoratorPatternDemo
 * @Author: zxb
 * @Date: 2020/10/12 16:22
 * @Description: 装饰者模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/decorator_pattern.htm
 */
public class DecoratorPatternDemo {

  public static void main(String[] args) {
    Shape circle = new Circle();

    Shape redCircle = new RedShapeDecorator(new Circle());

    Shape redRectangle = new RedShapeDecorator(new Rectangle());
    System.out.println("Circle with normal border");
    circle.draw();

    System.out.println("\nCircle of red border");
    redCircle.draw();

    System.out.println("\nRectangle of red border");
    redRectangle.draw();
  }

}
