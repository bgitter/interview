package com.zhang.interview.code.design.behavioral.observer;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Observer
 * @Author: zxb
 * @Date: 2020/10/14 13:47
 * @Description: 观察者模式-抽象类
 */
public abstract class Observer {

  protected Subject subject;

  /**
   * update
   */
  public abstract void update();

}
