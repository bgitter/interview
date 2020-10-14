package com.zhang.interview.code.design.behavioral.interpreter;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: OrExpression
 * @Author: zxb
 * @Date: 2020/10/14 10:20
 * @Description: 解释器模式-实现类
 */
public class OrExpression implements Expression {

  private Expression expr1 = null;
  private Expression expr2 = null;

  public OrExpression(Expression expr1, Expression expr2) {
    this.expr1 = expr1;
    this.expr2 = expr2;
  }

  @Override
  public boolean interpret(String context) {
    return expr1.interpret(context) || expr2.interpret(context);
  }
}
