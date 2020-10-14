package com.zhang.interview.code.design.servlet.composite;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: CompositeEntityPatternDemo
 * @Author: zxb
 * @Date: 2020/10/14 18:16
 * @Description: Composite模式
 * 示例代码：https://www.tutorialspoint.com/design_pattern/composite_entity_pattern.htm
 */
public class CompositeEntityPatternDemo {

  public static void main(String[] args) {
    Client client = new Client();
    client.setData("Test", "Data");
    client.printData();
    client.setData("Second Test", "Data1");
    client.printData();
  }

}
