package com.zhang.interview.code.design.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: CareTaker
 * @Author: zxb
 * @Date: 2020/10/14 11:18
 * @Description: 备忘录模式-恢复
 */
public class CareTaker {

  private List<Memento> mementos = new ArrayList<>();

  public void add(Memento state) {
    mementos.add(state);
  }

  public Memento get(int index) {
    return mementos.get(index);
  }
}
