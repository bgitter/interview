package com.zhang.interview.code.design.behavioral.state.s2;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: NoQuarterState
 * @Author: zxb
 * @Date: 2020/10/14 14:24
 * @Description: 状态模式-实现类
 */
public class NoQuarterState implements State {

  GumballMachine gumballMachine;

  public NoQuarterState(GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  @Override
  public void insertQuarter() {
    System.out.println("You insert a quarter");
    gumballMachine.setState(gumballMachine.getHasQuarterState());
  }

  @Override
  public void ejectQuarter() {
    System.err.println("You haven't insert a quarter");
  }

  @Override
  public void turnCrank() {
    System.err.println("You turned, but there's no quarter");
  }

  @Override
  public void dispense() {
    System.out.println("You need to pay first");
  }
}
