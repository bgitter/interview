package com.zhang.interview.code.design.behavioral.iterator;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Container
 * @Author: zxb
 * @Date: 2020/10/14 10:56
 * @Description: 迭代器模式-容器接口
 */
public interface Container {

  /**
   * getIterator
   *
   * @return iterator
   */
  Iterator getIterator();

}
