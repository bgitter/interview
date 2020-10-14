package com.zhang.interview.code.design.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Subject
 * @Author: zxb
 * @Date: 2020/10/14 13:48
 * @Description: 观察者模式-主体类
 */
public class Subject {

  private List<Observer> observers = new ArrayList<>();
  private int state;

  public void attach(Observer observer) {
    observers.add(observer);
  }

  public void notifyAllObservers() {
    for (Observer observer : observers) {
      observer.update();
    }
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
    notifyAllObservers();
  }
}
