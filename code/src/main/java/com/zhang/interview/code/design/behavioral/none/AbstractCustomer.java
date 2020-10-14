package com.zhang.interview.code.design.behavioral.none;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: AbstractCustomer
 * @Author: zxb
 * @Date: 2020/10/14 15:24
 * @Description: 空对象模式-抽象类
 */
public abstract class AbstractCustomer {

  protected String name;

  /**
   * isNil
   *
   * @return boolean
   */
  public abstract boolean isNil();

  /**
   * getName
   *
   * @return String
   */
  public abstract String getName();

}
