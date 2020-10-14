package com.zhang.interview.code.design.behavioral.state.s2;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Client
 * @Author: zxb
 * @Date: 2020/10/14 14:33
 * @Description: 状态模式-入口
 */
public class Client {

  public static void main(String[] args) throws InterruptedException {
    GumballMachine gumballMachine = new GumballMachine(5);

    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    System.out.println("");

    gumballMachine.insertQuarter();
    gumballMachine.ejectQuarter();
    gumballMachine.turnCrank();
    System.out.println("");

    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.ejectQuarter();
    System.out.println("");

    gumballMachine.insertQuarter();
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
  }

}
