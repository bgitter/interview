package com.zhang.interview.code.design.behavioral.visitor;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Computer
 * @Author: zxb
 * @Date: 2020/10/14 16:30
 * @Description: 访问者模式-接口实现类
 */
public class Computer implements ComputerPart {

  ComputerPart[] parts;

  public Computer() {
    this.parts = new ComputerPart[]{new Mouse(), new Keyboard(), new Monitor()};
  }

  @Override
  public void accept(ComputerPartVisitor visitor) {
    for (int i = 0; i < parts.length; i++) {
      parts[i].accept(visitor);
    }
    visitor.visit(this);
  }
}
