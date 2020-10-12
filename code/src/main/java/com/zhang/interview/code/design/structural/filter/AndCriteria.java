package com.zhang.interview.code.design.structural.filter;

import java.util.List;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: AndCriteria
 * @Author: zxb
 * @Date: 2020/10/12 15:39
 * @Description: 过滤器模式-实现类
 */
public class AndCriteria implements Criteria {

  private Criteria criteria;
  private Criteria otherCriteria;

  public AndCriteria(Criteria criteria, Criteria otherCriteria) {
    this.criteria = criteria;
    this.otherCriteria = otherCriteria;
  }

  @Override
  public List<Person> meetCriteria(List<Person> persons) {
    List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
    return otherCriteria.meetCriteria(firstCriteriaPersons);
  }
}
