package com.zhang.interview.code.design.structural.bridge;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: BridgePatternDemo
 * @Author: zxb
 * @Date: 2020/10/12 15:24
 * @Description: 桥接模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/bridge_pattern.htm
 */
public class BridgePatternDemo {

  public static void main(String[] args) {
    Shape redCircle = new Circle(100, 100, 10, new RedCircle());
    Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

    redCircle.draw();
    greenCircle.draw();
  }

}
