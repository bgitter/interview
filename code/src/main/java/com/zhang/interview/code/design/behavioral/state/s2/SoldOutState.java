package com.zhang.interview.code.design.behavioral.state.s2;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: SoldOutState
 * @Author: zxb
 * @Date: 2020/10/14 14:27
 * @Description: 状态模式-实现类
 */
public class SoldOutState implements State {

  GumballMachine gumballMachine;

  public SoldOutState(GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  @Override
  public void insertQuarter() {
    System.err.println("You can't insert a quarter, the machine is sold out");
  }

  @Override
  public void ejectQuarter() {
    System.err.println("You can't eject, you haven't inserted a quarter yet");
  }

  @Override
  public void turnCrank() {
    System.err.println("You turned, but there are not gumballs");
  }

  @Override
  public void dispense() {
    System.err.println("No gumball dispensed");
  }
}
