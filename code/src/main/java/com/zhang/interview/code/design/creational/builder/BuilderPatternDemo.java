package com.zhang.interview.code.design.creational.builder;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: BuilderPatternDemo
 * @Author: zxb
 * @Date: 2020/10/12 14:03
 * @Description: 构建者模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/builder_pattern.htm
 */
public class BuilderPatternDemo {

  public static void main(String[] args) {
    MealBuilder mealBuilder = new MealBuilder();

    Meal vegMeal = mealBuilder.prepareVegMeal();
    System.out.println("Veg Meal");
    vegMeal.showItems();
    System.out.println("Total Cost: " + vegMeal.getCost());

    Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
    System.out.println("\n\nNon-Veg Meal");
    nonVegMeal.showItems();
    System.out.println("Total cost: " + nonVegMeal.getCost());
  }

}
