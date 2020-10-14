package com.zhang.interview.code.design.behavioral.visitor;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ComputerPartDisplayVisitor
 * @Author: zxb
 * @Date: 2020/10/14 16:36
 * @Description: 访问者模式-访问者接口实现
 */
public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

  @Override
  public void visit(Computer computer) {
    System.out.println("Displaying Computer.");
  }

  @Override
  public void visit(Mouse mouse) {
    System.out.println("Displaying Mouse.");
  }

  @Override
  public void visit(Keyboard keyboard) {
    System.out.println("Displaying Keyboard.");
  }

  @Override
  public void visit(Monitor monitor) {
    System.out.println("Displaying Monitor.");
  }
}
