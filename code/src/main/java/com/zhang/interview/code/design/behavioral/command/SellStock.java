package com.zhang.interview.code.design.behavioral.command;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: SellStock
 * @Author: zxb
 * @Date: 2020/10/14 9:55
 * @Description: 命令模式-实现类
 */
public class SellStock implements Order {

  private Stock abcStock;

  public SellStock(Stock abcStock) {
    this.abcStock = abcStock;
  }

  @Override
  public void execute() {
    abcStock.sell();
  }
}
