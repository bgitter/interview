package com.zhang.interview.code.design.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Broker
 * @Author: zxb
 * @Date: 2020/10/14 10:01
 * @Description: 命令模式-回调类
 */
public class Broker {

  private List<Order> orders = new ArrayList<>();

  public void takeOrder(Order order) {
    orders.add(order);
  }

  public void placeOrders() {
    for (Order order : orders) {
      order.execute();
    }
    orders.clear();
  }
}
