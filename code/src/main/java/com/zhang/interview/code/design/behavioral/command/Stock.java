package com.zhang.interview.code.design.behavioral.command;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Stock
 * @Author: zxb
 * @Date: 2020/10/14 9:56
 * @Description: 命令模式-命令
 */
public class Stock {

  private String name = "ABC";
  private int quantity = 10;

  public void buy() {
    System.out.println(String.format("Stock [Name: %s, Quantity: %d] bought", name, quantity));
  }

  public void sell() {
    System.out.println(String.format("Stock [Name: %s, Quantity: %d] sold", name, quantity));
  }
}
