package com.zhang.interview.code.design.behavioral.chain;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ConsoleLogger
 * @Author: zxb
 * @Date: 2020/10/13 18:15
 * @Description: 调用链模式-控制台打印
 */
public class ConsoleLogger extends AbstractLogger {

  public ConsoleLogger(int level) {
    this.level = level;
  }

  @Override
  protected void write(String message) {
    System.out.println("Standard Console::Logger: " + message);
  }
}
