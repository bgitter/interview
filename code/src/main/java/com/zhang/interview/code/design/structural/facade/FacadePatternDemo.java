package com.zhang.interview.code.design.structural.facade;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: FacadePatternDemo
 * @Author: zxb
 * @Date: 2020/10/13 16:03
 * @Description: 外观模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/facade_pattern.htm
 */
public class FacadePatternDemo {

  public static void main(String[] args) {
    ShapeMaker maker = new ShapeMaker();
    maker.drawCircle();
    maker.drawRectangle();
    maker.drawSquare();
  }

}
