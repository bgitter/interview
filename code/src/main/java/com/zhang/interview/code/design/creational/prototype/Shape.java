package com.zhang.interview.code.design.creational.prototype;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Shape
 * @Author: zxb
 * @Date: 2020/10/12 14:12
 * @Description: 原型模式-抽象类
 */
public abstract class Shape implements Cloneable {

  private String id;

  protected String type;

  /**
   * draw
   */
  abstract void draw();

  public String getType() {
    return type;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public Object clone() {
    Object clone = null;
    try {
      clone = super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return clone;
  }
}
