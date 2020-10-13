package com.zhang.interview.code.design.behavioral.chain;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ErrorLogger
 * @Author: zxb
 * @Date: 2020/10/13 18:16
 * @Description: 调用链模式-错误打印
 */
public class ErrorLogger extends AbstractLogger {

  public ErrorLogger(int level) {
    this.level = level;
  }

  @Override
  protected void write(String message) {
    System.err.println("Error Console::Logger: " + message);
  }
}
