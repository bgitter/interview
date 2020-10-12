package com.zhang.interview.code.design.structural.filter;

import java.util.List;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: OrCriteria
 * @Author: zxb
 * @Date: 2020/10/12 15:41
 * @Description: 过滤器模式-实现类
 */
public class OrCriteria implements Criteria {

  private Criteria criteria;
  private Criteria otherCriteria;

  public OrCriteria(Criteria criteria, Criteria otherCriteria) {
    this.criteria = criteria;
    this.otherCriteria = otherCriteria;
  }

  @Override
  public List<Person> meetCriteria(List<Person> persons) {
    List<Person> firstCriteriaItems = criteria.meetCriteria(persons);
    List<Person> otherCriteriaItems = otherCriteria.meetCriteria(persons);

    for (Person person : otherCriteriaItems) {
      if (!firstCriteriaItems.contains(person)) {
        firstCriteriaItems.add(person);
      }
    }
    return firstCriteriaItems;
  }
}
