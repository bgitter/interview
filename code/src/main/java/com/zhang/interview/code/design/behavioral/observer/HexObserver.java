package com.zhang.interview.code.design.behavioral.observer;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: HexObserver
 * @Author: zxb
 * @Date: 2020/10/14 13:55
 * @Description: 观察者模式-实现类
 */
public class HexObserver extends Observer {

  public HexObserver(Subject subject) {
    this.subject = subject;
    this.subject.attach(this);
  }

  @Override
  public void update() {
    System.out.println("Hex String: " + Integer.toHexString(subject.getState()));
  }
}
