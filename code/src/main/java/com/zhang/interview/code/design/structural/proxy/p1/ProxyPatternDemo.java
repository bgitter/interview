package com.zhang.interview.code.design.structural.proxy.p1;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ProxyPatternDemo
 * @Author: zxb
 * @Date: 2020/10/13 16:59
 * @Description: 代理模式-入口 静态代理
 * 示例代码：https://www.tutorialspoint.com/design_pattern/proxy_pattern.htm
 */
public class ProxyPatternDemo {

  public static void main(String[] args) {
    Image image = new ProxyImage("test_10mb.jpg");

    // image will be loaded from disk
    image.display();
    System.out.println("");

    // image will not be loaded from disk
    image.display();
  }

}
