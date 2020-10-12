package com.zhang.interview.code.design.creational.singleton.s8;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: EnumInstance
 * @Author: zxb
 * @Date: 2020/10/12 11:16
 * @Description: 单例模式-懒汉模式 使用枚举类实现防止破坏单例
 */
public enum EnumInstance {

  INSTANCE;

  private String field;

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public static EnumInstance getInstance() {
    return INSTANCE;
  }
}
