package com.zhang.interview.code.design.behavioral.strategy;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Context
 * @Author: zxb
 * @Date: 2020/10/14 15:40
 * @Description: 策略模式-上下文
 */
public class Context {

  private Strategy strategy;

  public Context(Strategy strategy) {
    this.strategy = strategy;
  }

  public int executeStrategy(int a, int b) {
    return strategy.doOperation(a, b);
  }
}
