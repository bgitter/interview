package com.zhang.interview.code.design.servlet.composite;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: CoarseGrainedObject
 * @Author: zxb
 * @Date: 2020/10/14 18:11
 * @Description: Composite模式
 */
public class CoarseGrainedObject {

  DependentObject1 do1 = new DependentObject1();
  DependentObject2 do2 = new DependentObject2();

  public void setData(String data1, String data2) {
    do1.setData(data1);
    do2.setData(data2);
  }

  public String[] getData() {
    return new String[]{do1.getData(), do2.getData()};
  }
}
