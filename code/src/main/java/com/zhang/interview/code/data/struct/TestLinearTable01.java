package com.zhang.interview.code.data.struct;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright (C), 2018-2021, 北京数知科技股份有限公司
 * @FileName: TestLinearTable01
 * @Author: zxb
 * @Date: 2021/3/1 14:46
 * @Description: 建立一个顺序存储的线性表，查找顺序表中第一个出现的值为z的元素并输出其位置。
 * 1.建立一个顺序存储的线性表；
 * 2.首先初始化线性表，并且插入值为 z 的元素；
 * 3.查找第一个出现值为 z 的元素；
 * 4.对于位置的判断需要考虑是否符合要求；
 * 5.并输出该元素的位置。
 */
public class TestLinearTable01 {

  public static void main(String[] args) {
    // 1.建立一个顺序存储的线性表
    List<Character> list = new ArrayList(10);
    // 首先初始化线性表，并且插入值为 z 的元素
    list.add(0, 'a');
    list.add(1, 'z');
    list.add(2, 'd');
    list.add(3, 'm');
    list.add(4, 'z');
    // 3.查找第一个出现值为z的元素
    int location = list.indexOf('z');
    // 对于位置的判断需要考虑是否符合要求
    if (location != -1) {
      System.out.println("第一次出现 z 元素的位置为：" + location);
    } else {
      System.out.println("顺序表中不存在值为 z 的元素");
    }
  }

}