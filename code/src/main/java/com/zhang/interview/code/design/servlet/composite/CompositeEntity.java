package com.zhang.interview.code.design.servlet.composite;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: CompositeEntity
 * @Author: zxb
 * @Date: 2020/10/14 18:09
 * @Description: Composite模式-实体
 */
public class CompositeEntity {

  private CoarseGrainedObject cgo = new CoarseGrainedObject();

  public void setData(String data1, String data2) {
    cgo.setData(data1, data2);
  }

  public String[] getData() {
    return cgo.getData();
  }
}
