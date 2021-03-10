package com.zhang.interview.code.data.struct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Copyright (C), 2018-2021, 北京数知科技股份有限公司
 * @FileName: TestLinearTable02
 * @Author: zxb
 * @Date: 2021/3/1 15:40
 * @Description: 编程实现查找线性表(0, 1, 2, 3, ...n - 1)中第i个数据元素的直接前驱和后继，并输出它的值。在顺序表中实现。
 * 1.初始化线性表并构造一个有50个空间的顺序表
 * 2.在线性表中插入元素，按照（i, i）,i = 0,1,2 ...
 * 3.用户输入 i 的值，表示查找第几个元素的前驱和后继
 * 4.查找线性表中第 i 个元素的前驱，并输出
 * 5.查找线性表中的第 i 个元素的后继，并输出
 */
public class TestLinearTable02 {

  public static void main(String[] args) {
    // 初始化线性表并构造一个有50个空间的顺序表
    List<Integer> list = new ArrayList(50);
    // 在线性表中插入元素，按照(i,i),i = 0,1,2...
    int n = 20;
    for (int i = 0; i < n; i++) {
      list.add(i, i);
    }
    // 用户输入 i 的值，表示查找第几个元素的前驱和后继
    System.out.println("请您输入要查询的元素");
    int in = new Scanner(System.in).nextInt();
    // 查找线性表中第 i 个元素的前驱，并输出
    if (in > 0 && in < n) {
      Integer x = list.get(in - 1);
      System.out.println("第" + in + "个元素的前驱为：" + x);
    } else {
      System.out.println("第" + in + "个元素的前驱不存在");
    }
    // 查找线性表中的第 i 个元素的后去，并输出
    if (in >= 0 && in < n - 1) {
      Object x = list.get(in + 1);
      System.out.println("第" + in + "个元素的后继为：" + x);
    } else {
      System.out.println("第" + in + "个元素的后继不存在");
    }
  }

}