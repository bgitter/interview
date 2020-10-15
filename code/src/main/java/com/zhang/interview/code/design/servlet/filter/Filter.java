package com.zhang.interview.code.design.servlet.filter;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Filter
 * @Author: zxb
 * @Date: 2020/10/15 13:59
 * @Description: Filter模式-接口
 */
public interface Filter {

  /**
   * execute
   *
   * @param request request
   */
  void execute(String request);

}
