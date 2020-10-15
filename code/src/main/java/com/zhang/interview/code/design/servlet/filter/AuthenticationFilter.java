package com.zhang.interview.code.design.servlet.filter;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: AuthenticationFilter
 * @Author: zxb
 * @Date: 2020/10/15 14:01
 * @Description: Filter模式-实现类
 */
public class AuthenticationFilter implements Filter {

  @Override
  public void execute(String request) {
    System.out.println("Authenticating request: " + request);
  }
}
