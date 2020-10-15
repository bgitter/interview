package com.zhang.interview.code.design.servlet.filter;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: FilterManager
 * @Author: zxb
 * @Date: 2020/10/15 14:04
 * @Description: Filter模式-过滤器管理类
 */
public class FilterManager {

  FilterChain filterChain;

  public FilterManager(Target target) {
    this.filterChain = new FilterChain();
    this.filterChain.setTarget(target);
  }

  public void setFilter(Filter filter) {
    filterChain.addFilter(filter);
  }

  public void filterRequest(String request) {
    filterChain.execute(request);
  }
}
