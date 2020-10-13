package com.zhang.interview.code.design.behavioral.chain;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: InfoLogger
 * @Author: zxb
 * @Date: 2020/10/13 18:17
 * @Description: 调用链模式-普通打印
 */
public class InfoLogger extends AbstractLogger {

  public InfoLogger(int level) {
    this.level = level;
  }

  @Override
  protected void write(String message) {
    System.out.println("Info Console::Logger: " + message);
  }
}
