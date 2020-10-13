package com.zhang.interview.code.design.structural.proxy.p2;


/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ProxyPatternDemo
 * @Author: zxb
 * @Date: 2020/10/13 16:59
 * @Description: 代理模式-入口 JDK动态代理
 * 说明：JDK动态代理的对象必须实现一个接口
 */
public class ProxyPatternDemo {

  public static void main(String[] args) {
    ProxyImage proxyImage = new ProxyImage(new RealImage("test_10mb.jpg"));
    Image image = (Image) proxyImage.createObject();
    image.display();

    System.out.println("");
    image.display();
  }

}
