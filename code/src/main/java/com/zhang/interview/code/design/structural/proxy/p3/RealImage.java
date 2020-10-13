package com.zhang.interview.code.design.structural.proxy.p3;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: RealImage
 * @Author: zxb
 * @Date: 2020/10/13 17:22
 * @Description: 代理模式-CGLib
 */
public class RealImage {

  private String fileName;

  public RealImage() {
  }

  public RealImage(String fileName) {
    this.fileName = fileName;
    loadFromDisk(fileName);
  }

  private void loadFromDisk(String fileName) {
    System.out.println("Loading " + fileName);
  }

  public void display() {
    System.out.println("Displaying " + fileName);
  }

}
