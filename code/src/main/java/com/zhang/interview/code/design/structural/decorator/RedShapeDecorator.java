package com.zhang.interview.code.design.structural.decorator;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: RedShapeDecorator
 * @Author: zxb
 * @Date: 2020/10/12 16:20
 * @Description: 装饰者模式-扩展装饰
 */
public class RedShapeDecorator extends ShapeDecorator {

  public RedShapeDecorator(Shape decoratorShape) {
    super(decoratorShape);
  }

  @Override
  public void draw() {
    decoratorShape.draw();
    setRedBorder(decoratorShape);
  }

  private void setRedBorder(Shape decoratorShape) {
    System.out.println("Border Color: Red");
  }
}
