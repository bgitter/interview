package com.zhang.interview.code.design.servlet.filter;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Client
 * @Author: zxb
 * @Date: 2020/10/15 14:06
 * @Description: Filter模式-客户端类
 */
public class Client {

  FilterManager filterManager;

  public void setFilterManager(FilterManager filterManager) {
    this.filterManager = filterManager;
  }

  public void sendRequest(String request) {
    filterManager.filterRequest(request);
  }
}
