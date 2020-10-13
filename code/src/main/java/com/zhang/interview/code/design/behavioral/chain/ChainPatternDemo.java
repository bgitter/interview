package com.zhang.interview.code.design.behavioral.chain;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ChainPatternDemo
 * @Author: zxb
 * @Date: 2020/10/13 18:18
 * @Description: 调用链模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/chain_of_responsibility_pattern.htm
 */
public class ChainPatternDemo {

  private static AbstractLogger getChainOfLoggers() {

    AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
    AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);
    AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.DEBUG);

    errorLogger.setNextLogger(infoLogger);
    infoLogger.setNextLogger(consoleLogger);

    return errorLogger;
  }

  public static void main(String[] args) {
    AbstractLogger loggerChain = getChainOfLoggers();
    loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
    System.out.println("");
    loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");
    System.out.println("");
    loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
  }

}
