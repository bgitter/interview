package com.zhang.interview.code.design.creational.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Meal
 * @Author: zxb
 * @Date: 2020/10/12 13:58
 * @Description: 构建者模式-餐
 */
public class Meal {

  private List<Item> items = new ArrayList<>();

  /**
   * add item
   *
   * @param item item
   */
  public void addItem(Item item) {
    items.add(item);
  }

  /**
   * get cost
   *
   * @return cost
   */
  public float getCost() {
    float cost = 0.0F;
    for (Item item : items) {
      cost += item.price();
    }
    return cost;
  }

  public void showItems() {
    for (Item item : items) {
      System.out.print("Item: " + item.name());
      System.out.print(", Packing: " + item.packing().pack());
      System.out.println(", Price: " + item.price());
    }
  }
}
