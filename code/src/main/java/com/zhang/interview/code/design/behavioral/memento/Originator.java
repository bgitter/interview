package com.zhang.interview.code.design.behavioral.memento;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Originator
 * @Author: zxb
 * @Date: 2020/10/14 11:17
 * @Description: 备忘录模式-存储
 */
public class Originator {

  private String state;

  public Memento saveStateToMemento() {
    return new Memento(state);
  }

  public void getStateFromMemento(Memento memento) {
    this.state = memento.getState();
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}
