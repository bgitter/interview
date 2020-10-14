package com.zhang.interview.code.design.behavioral.state.s2;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: GumballMachine
 * @Author: zxb
 * @Date: 2020/10/14 14:16
 * @Description: 状态模式-上下文
 */
public class GumballMachine {

  private State soldOutState;
  private State noQuarterState;
  private State hasQuarterState;
  private State soldState;

  private State state;
  private int count = 0;

  public GumballMachine(int numberGumballs) {
    this.count = numberGumballs;

    soldOutState = new SoldOutState(this);
    noQuarterState = new NoQuarterState(this);
    hasQuarterState = new HasQuarterState(this);
    soldState = new SoldState(this);

    if (numberGumballs > 0) {
      state = noQuarterState;
    } else {
      state = soldOutState;
    }
  }

  public void insertQuarter() {
    state.insertQuarter();
  }

  public void ejectQuarter() {
    state.ejectQuarter();
  }

  public void turnCrank() {
    state.turnCrank();
    state.dispense();
  }

  public void releaseBall() {
    System.out.println("A gumball comes rolling out the slot...");
    if (count != 0) {
      count -= 1;
    }
  }

  public void setState(State state) {
    this.state = state;
  }

  public State getSoldOutState() {
    return soldOutState;
  }

  public State getNoQuarterState() {
    return noQuarterState;
  }

  public State getHasQuarterState() {
    return hasQuarterState;
  }

  public State getSoldState() {
    return soldState;
  }

  public int getCount() {
    return count;
  }
}
