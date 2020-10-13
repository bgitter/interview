package com.zhang.interview.code.design.structural.proxy.p3;


/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ProxyPatternDemo
 * @Author: zxb
 * @Date: 2020/10/13 16:59
 * @Description: 代理模式-入口 CGLib动态代理
 * 说明：CGLib动态代理的对象不能使用final修饰
 */
public class ProxyPatternDemo {

  public static void main(String[] args) {
    CglibProxy proxyImage = new CglibProxy(new RealImage("test_10mb.jpg"));
    RealImage image = (RealImage) proxyImage.createProxyObject();
    image.display();

    System.out.println("");
    image.display();
  }

}
