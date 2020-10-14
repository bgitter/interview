package com.zhang.interview.code.design.behavioral.interpreter;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Expression
 * @Author: zxb
 * @Date: 2020/10/14 10:18
 * @Description: 解释器模式-接口
 */
public interface Expression {

  /**
   * interpret
   *
   * @param context 上下文
   * @return true or false
   */
  boolean interpret(String context);

}
