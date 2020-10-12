package com.zhang.interview.code.design.structural.decorator;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ShapeDecorator
 * @Author: zxb
 * @Date: 2020/10/12 16:19
 * @Description: 装饰者模式-装饰抽象
 */
public abstract class ShapeDecorator implements Shape {

  protected Shape decoratorShape;

  public ShapeDecorator(Shape decoratorShape) {
    this.decoratorShape = decoratorShape;
  }

  @Override
  public void draw() {
    decoratorShape.draw();
  }

}
