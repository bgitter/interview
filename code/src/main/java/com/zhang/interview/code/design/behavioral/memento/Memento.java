package com.zhang.interview.code.design.behavioral.memento;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Memento
 * @Author: zxb
 * @Date: 2020/10/14 11:17
 * @Description: 备忘录模式-备忘录
 */
public class Memento {

  private String state;

  public Memento(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }
}
