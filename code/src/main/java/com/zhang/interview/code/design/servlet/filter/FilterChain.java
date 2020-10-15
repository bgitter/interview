package com.zhang.interview.code.design.servlet.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: FilterChain
 * @Author: zxb
 * @Date: 2020/10/15 14:02
 * @Description: Filter模式-过滤器链
 */
public class FilterChain {

  private List<Filter> filters = new ArrayList<>();
  private Target target;

  public void addFilter(Filter filter) {
    filters.add(filter);
  }

  public void execute(String request) {
    for (Filter filter : filters) {
      filter.execute(request);
    }
    target.execute(request);
  }

  public void setTarget(Target target) {
    this.target = target;
  }
}
