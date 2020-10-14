package com.zhang.interview.code.design.behavioral.state.s2;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: HasQuarterState
 * @Author: zxb
 * @Date: 2020/10/14 14:15
 * @Description: 状态模式-实现类
 */
public class HasQuarterState implements State {

  private GumballMachine gumballMachine;

  public HasQuarterState(GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  @Override
  public void insertQuarter() {
    System.err.println("You can't insert another quarter");
  }

  @Override
  public void ejectQuarter() {
    System.out.println("Quarter returned");
    gumballMachine.setState(gumballMachine.getNoQuarterState());
  }

  @Override
  public void turnCrank() {
    System.out.println("You turned...");
    gumballMachine.setState(gumballMachine.getSoldState());
  }

  @Override
  public void dispense() {
    System.err.println("No gumball dispensed");
  }
}
