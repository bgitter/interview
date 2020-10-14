package com.zhang.interview.code.design.behavioral.memento;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: MementoPatternDemo
 * @Author: zxb
 * @Date: 2020/10/14 11:21
 * @Description: 备忘录模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/memento_pattern.htm
 */
public class MementoPatternDemo {

  public static void main(String[] args) {
    Originator originator = new Originator();
    CareTaker careTaker = new CareTaker();

    originator.setState("State #1");
    originator.setState("State #2");
    careTaker.add(originator.saveStateToMemento());

    originator.setState("State #3");
    careTaker.add(originator.saveStateToMemento());

    originator.setState("State #4");
    System.out.println("Current State: " + originator.getState());

    originator.getStateFromMemento(careTaker.get(0));
    System.out.println("First saved State: " + originator.getState());
    originator.getStateFromMemento(careTaker.get(1));
    System.out.println("Second saved State: " + originator.getState());
  }

}
