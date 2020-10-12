package com.zhang.interview.code.design.structural.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: CriteriaSingle
 * @Author: zxb
 * @Date: 2020/10/12 15:38
 * @Description: 过滤器模式-实现类
 */
public class CriteriaSingle implements Criteria {

  @Override
  public List<Person> meetCriteria(List<Person> persons) {
    List<Person> singlePersons = new ArrayList<>();
    for (Person person : persons) {
      if (person.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
        singlePersons.add(person);
      }
    }
    return singlePersons;
  }
}
