package com.zhang.interview.code.design.behavioral.visitor;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ComputerPart
 * @Author: zxb
 * @Date: 2020/10/14 16:28
 * @Description: 访问者模式-接口
 */
public interface ComputerPart {

  /**
   * accept
   *
   * @param visitor visitor
   */
  void accept(ComputerPartVisitor visitor);

}
