package com.zhang.interview.code.design.behavioral.state.s1;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Context
 * @Author: zxb
 * @Date: 2020/10/14 14:06
 * @Description: 状态模式-上下文
 */
public class Context {

  private State state;

  public Context() {
    state = null;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }
}
