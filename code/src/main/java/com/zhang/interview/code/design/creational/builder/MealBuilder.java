package com.zhang.interview.code.design.creational.builder;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: MealBuilder
 * @Author: zxb
 * @Date: 2020/10/12 14:01
 * @Description: 构建者模式-构建者
 */
public class MealBuilder {

  /**
   * 蔬菜套餐
   *
   * @return meal
   */
  public Meal prepareVegMeal() {
    Meal meal = new Meal();
    meal.addItem(new VegBurger());
    meal.addItem(new Coke());
    return meal;
  }

  /**
   * 鸡肉套餐
   *
   * @return meal
   */
  public Meal prepareNonVegMeal() {
    Meal meal = new Meal();
    meal.addItem(new ChickenBurger());
    meal.addItem(new Pepsi());
    return meal;
  }
}
