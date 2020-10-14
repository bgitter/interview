package com.zhang.interview.code.design.servlet.biz;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: BusinessDelegate
 * @Author: zxb
 * @Date: 2020/10/14 17:58
 * @Description: BusinessDelegate模式
 */
public class BusinessDelegate {

  private BusinessLookup lookup = new BusinessLookup();
  private BusinessService businessService;
  private String serviceType;

  public void setServiceType(String serviceType) {
    this.serviceType = serviceType;
  }

  public void doTask() {
    businessService = lookup.getBusinessService(serviceType);
    businessService.doProcessing();
  }
}
