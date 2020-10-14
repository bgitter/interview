package com.zhang.interview.code.design.behavioral.iterator;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: IteratorPatternDemo
 * @Author: zxb
 * @Date: 2020/10/14 11:00
 * @Description: 迭代器模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/iterator_pattern.htm
 */
public class IteratorPatternDemo {

  public static void main(String[] args) {
    NameRepository nameRepository = new NameRepository();
    Iterator iterator = nameRepository.getIterator();
    while (iterator.hasNext()) {
      System.out.println("Name: " + iterator.next());
    }
  }

}
