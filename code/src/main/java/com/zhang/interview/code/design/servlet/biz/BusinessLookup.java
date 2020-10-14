package com.zhang.interview.code.design.servlet.biz;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: BusinessLookup
 * @Author: zxb
 * @Date: 2020/10/14 17:20
 * @Description: BusinessDelegate模式-service
 */
public class BusinessLookup {

  public BusinessService getBusinessService(String serviceType) {
    if (serviceType.equalsIgnoreCase("EJB")) {
      return new EJBService();
    } else {
      return new JMSService();
    }
  }

}
