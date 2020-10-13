package com.zhang.interview.code.design.behavioral.chain;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: AbstractLogger
 * @Author: zxb
 * @Date: 2020/10/13 18:11
 * @Description: 调用链模式-抽象类
 */
public abstract class AbstractLogger {

  public static final int DEBUG = 1;
  public static final int INFO = 2;
  public static final int ERROR = 3;

  protected int level;
  /**
   * next element in chain or responsibility
   */
  protected AbstractLogger nextLogger;

  public void setNextLogger(AbstractLogger logger) {
    this.nextLogger = logger;
  }

  public void logMessage(int level, String message) {
    if (this.level <= level) {
      write(message);
    }
    if (nextLogger != null) {
      nextLogger.logMessage(level, message);
    }
  }

  /**
   * 打印消息
   *
   * @param message 消息
   */
  abstract protected void write(String message);
}