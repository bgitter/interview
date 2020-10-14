package com.zhang.interview.code.design.behavioral.mediator;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: MediatorPatternDemo
 * @Author: zxb
 * @Date: 2020/10/14 11:10
 * @Description: 中介模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/mediator_pattern.htm
 */
public class MediatorPatternDemo {

  public static void main(String[] args) {
    User robert = new User("Robert");
    User john = new User("John");

    robert.sendMessage("Hi! John!");
    john.sendMessage("Hello! Robert!");
  }

}
