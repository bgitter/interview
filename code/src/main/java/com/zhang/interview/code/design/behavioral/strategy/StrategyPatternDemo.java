package com.zhang.interview.code.design.behavioral.strategy;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: StrategyPatternDemo
 * @Author: zxb
 * @Date: 2020/10/14 15:41
 * @Description: 策略模式 - 入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
 */
public class StrategyPatternDemo {

  public static void main(String[] args) {
    Context context = new Context(new OperationAdd());
    System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

    context = new Context(new OperationSub());
    System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

    context = new Context(new OperationMulti());
    System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
  }

}
