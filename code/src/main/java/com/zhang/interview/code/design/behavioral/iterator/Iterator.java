package com.zhang.interview.code.design.behavioral.iterator;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Iterator
 * @Author: zxb
 * @Date: 2020/10/14 10:55
 * @Description: 迭代器模式-迭代接口
 */
public interface Iterator {

  /**
   * hasNext
   *
   * @return boolean
   */
  boolean hasNext();

  /**
   * next
   *
   * @return object
   */
  Object next();

}
