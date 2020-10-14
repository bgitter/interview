package com.zhang.interview.code.design.behavioral.strategy;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: OperationSub
 * @Author: zxb
 * @Date: 2020/10/14 15:38
 * @Description: 策略模式-减法实现
 */
public class OperationSub implements Strategy {

  @Override
  public int doOperation(int a, int b) {
    return a - b;
  }
}
