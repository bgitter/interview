package com.zhang.interview.code.design.servlet.filter;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: InterceptingFilterDemo
 * @Author: zxb
 * @Date: 2020/10/15 14:07
 * @Description: Filter模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/intercepting_filter_pattern.htm
 */
public class InterceptingFilterDemo {

  public static void main(String[] args) {
    FilterManager filterManager = new FilterManager(new Target());
    filterManager.setFilter(new AuthenticationFilter());
    filterManager.setFilter(new DebugFilter());

    Client client = new Client();
    client.setFilterManager(filterManager);
    client.sendRequest("HOME");
  }

}
