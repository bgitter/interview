package com.zhang.interview.code.design.servlet.composite;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Client
 * @Author: zxb
 * @Date: 2020/10/14 18:14
 * @Description: Composite模式
 */
public class Client {

  private CompositeEntity entity = new CompositeEntity();

  public void printData() {
    String[] data = entity.getData();
    for (int i = 0; i < data.length; i++) {
      System.out.println("Data: " + data[i]);
    }
  }

  public void setData(String data1, String data2) {
    entity.setData(data1, data2);
  }
}
