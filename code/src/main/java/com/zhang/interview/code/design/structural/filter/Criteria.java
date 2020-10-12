package com.zhang.interview.code.design.structural.filter;

import java.util.List;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Criteria
 * @Author: zxb
 * @Date: 2020/10/12 15:31
 * @Description: 过滤器模式-接口
 */
public interface Criteria {

  /**
   * meetCriteria
   *
   * @param persons list
   * @return
   */
  List<Person> meetCriteria(List<Person> persons);

}
