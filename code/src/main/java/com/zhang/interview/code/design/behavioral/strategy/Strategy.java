package com.zhang.interview.code.design.behavioral.strategy;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Strategy
 * @Author: zxb
 * @Date: 2020/10/14 15:37
 * @Description: 策略模式-接口
 */
public interface Strategy {

  /**
   * doOperation
   *
   * @param a a
   * @param b b
   * @return result
   */
  int doOperation(int a, int b);

}
