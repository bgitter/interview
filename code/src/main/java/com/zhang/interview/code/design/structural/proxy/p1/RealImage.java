package com.zhang.interview.code.design.structural.proxy.p1;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: RealImage
 * @Author: zxb
 * @Date: 2020/10/13 16:56
 * @Description: 代理模式-实现类
 */
public class RealImage implements Image {

  private String fileName;

  public RealImage(String fileName) {
    this.fileName = fileName;
    loadFromDisk(fileName);
  }

  private void loadFromDisk(String fileName) {
    System.out.println("Loading " + fileName);
  }

  @Override
  public void display() {
    System.out.println("Displaying " + fileName);
  }
}
