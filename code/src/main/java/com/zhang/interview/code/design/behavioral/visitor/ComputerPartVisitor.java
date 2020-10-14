package com.zhang.interview.code.design.behavioral.visitor;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ComputerPartVisitor
 * @Author: zxb
 * @Date: 2020/10/14 16:31
 * @Description: 访问者模式-访问接口
 */
public interface ComputerPartVisitor {

  /**
   * visit
   *
   * @param computer computer
   */
  void visit(Computer computer);

  /**
   * visit
   *
   * @param mouse mouse
   */
  void visit(Mouse mouse);

  /**
   * visit
   *
   * @param keyboard keyboard
   */
  void visit(Keyboard keyboard);

  /**
   * visit
   *
   * @param monitor monitor
   */
  void visit(Monitor monitor);

}
