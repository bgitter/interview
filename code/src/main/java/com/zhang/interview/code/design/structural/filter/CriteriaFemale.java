package com.zhang.interview.code.design.structural.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: CriteriaFemale
 * @Author: zxb
 * @Date: 2020/10/12 15:36
 * @Description: 过滤器模式-实现类
 */
public class CriteriaFemale implements Criteria {

  @Override
  public List<Person> meetCriteria(List<Person> persons) {
    List<Person> femalePersons = new ArrayList<>();
    for (Person person : persons) {
      if (person.getGender().equalsIgnoreCase("FEMALE")) {
        femalePersons.add(person);
      }
    }
    return femalePersons;
  }
}
