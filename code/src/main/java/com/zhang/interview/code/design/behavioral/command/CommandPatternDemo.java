package com.zhang.interview.code.design.behavioral.command;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: CommandPatternDemo
 * @Author: zxb
 * @Date: 2020/10/14 10:03
 * @Description: 命令模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/command_pattern.htm
 */
public class CommandPatternDemo {

  public static void main(String[] args) {
    Stock abcStock = new Stock();
    BuyStock buyStock = new BuyStock(abcStock);
    SellStock sellStock = new SellStock(abcStock);

    Broker broker = new Broker();
    broker.takeOrder(buyStock);
    broker.takeOrder(sellStock);

    broker.placeOrders();
  }

}
