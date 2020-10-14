package com.zhang.interview.code.design.behavioral.visitor;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Mouse
 * @Author: zxb
 * @Date: 2020/10/14 16:29
 * @Description: 访问者模式-接口实现类
 */
public class Mouse implements ComputerPart {

  @Override
  public void accept(ComputerPartVisitor visitor) {
    visitor.visit(this);
  }
}
