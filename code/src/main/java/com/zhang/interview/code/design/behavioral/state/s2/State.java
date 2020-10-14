package com.zhang.interview.code.design.behavioral.state.s2;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: State
 * @Author: zxb
 * @Date: 2020/10/14 14:13
 * @Description: 状态模式-接口
 */
public interface State {

  /**
   * 投入 25 分钱
   */
  void insertQuarter();

  /**
   * 退回25 分钱
   */
  void ejectQuarter();

  /**
   * 转动曲柄
   */
  void turnCrank();

  /**
   * 发放糖果
   */
  void dispense();
}
