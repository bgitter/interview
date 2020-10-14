package com.zhang.interview.code.design.behavioral.observer;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ObserverPatternDemo
 * @Author: zxb
 * @Date: 2020/10/14 13:56
 * @Description: 观察者模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/observer_pattern.htm
 */
public class ObserverPatternDemo {

  public static void main(String[] args) {
    Subject subject = new Subject();
    new HexObserver(subject);
    new OctalObserver(subject);
    new BinaryObserver(subject);

    System.out.println("First state change: 15");
    subject.setState(15);

    System.out.println("\nSecond state change: 10");
    subject.setState(10);
  }

}
