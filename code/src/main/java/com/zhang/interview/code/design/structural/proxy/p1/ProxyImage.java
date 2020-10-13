package com.zhang.interview.code.design.structural.proxy.p1;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ProxyImage
 * @Author: zxb
 * @Date: 2020/10/13 16:58
 * @Description: 代理模式-代理类
 */
public class ProxyImage implements Image {

  private RealImage realImage;
  private String fileName;

  public ProxyImage(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public void display() {
    System.out.println("display begin...");
    if (realImage == null) {
      realImage = new RealImage(this.fileName);
    }
    realImage.display();
    System.out.println("display end...");
  }
}
