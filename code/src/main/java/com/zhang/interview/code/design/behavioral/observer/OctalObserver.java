package com.zhang.interview.code.design.behavioral.observer;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: OctalObserver
 * @Author: zxb
 * @Date: 2020/10/14 13:53
 * @Description: 观察者模式-实现类
 */
public class OctalObserver extends Observer {

  public OctalObserver(Subject subject) {
    this.subject = subject;
    this.subject.attach(this);
  }

  @Override
  public void update() {
    System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
  }
}
