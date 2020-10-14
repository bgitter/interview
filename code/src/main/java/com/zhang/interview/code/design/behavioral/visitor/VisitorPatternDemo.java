package com.zhang.interview.code.design.behavioral.visitor;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: VisitorPatternDemo
 * @Author: zxb
 * @Date: 2020/10/14 16:38
 * @Description: 访问者模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/visitor_pattern.htm
 */
public class VisitorPatternDemo {

  public static void main(String[] args) {
    ComputerPart computer = new Computer();
    computer.accept(new ComputerPartDisplayVisitor());
  }

}
