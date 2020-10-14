package com.zhang.interview.code.design.servlet.biz;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: EJBService
 * @Author: zxb
 * @Date: 2020/10/14 17:47
 * @Description: BusinessDelegate模式-EJB服务
 */
public class EJBService implements BusinessService {

  @Override
  public void doProcessing() {
    System.out.println("Processing task by invoking EJB Service");
  }
}
