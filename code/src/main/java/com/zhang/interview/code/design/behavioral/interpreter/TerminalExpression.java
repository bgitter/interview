package com.zhang.interview.code.design.behavioral.interpreter;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: TerminalExpression
 * @Author: zxb
 * @Date: 2020/10/14 10:20
 * @Description: 解释器模式-实现类
 */
public class TerminalExpression implements Expression {

  private String data;

  public TerminalExpression(String data) {
    this.data = data;
  }

  @Override
  public boolean interpret(String context) {
    if (context.contains(data)) {
      return true;
    }
    return false;
  }
}
