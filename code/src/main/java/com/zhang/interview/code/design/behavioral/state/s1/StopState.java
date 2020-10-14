package com.zhang.interview.code.design.behavioral.state.s1;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: StopState
 * @Author: zxb
 * @Date: 2020/10/14 14:08
 * @Description: 状态模式-停止状态
 */
public class StopState implements State {

  @Override
  public void doAction(Context context) {
    System.out.println("Player is in stop state");
    context.setState(this);
  }

  @Override
  public String toString() {
    return "Stop State";
  }
}
