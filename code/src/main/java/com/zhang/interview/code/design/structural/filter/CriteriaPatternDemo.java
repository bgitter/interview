package com.zhang.interview.code.design.structural.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: CriteriaPatternDemo
 * @Author: zxb
 * @Date: 2020/10/12 15:43
 * @Description: 过滤器模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/filter_pattern.htm
 */
public class CriteriaPatternDemo {

  public static void main(String[] args) {
    List<Person> persons = new ArrayList<>();

    persons.add(new Person("Robert", "Male", "Single"));
    persons.add(new Person("John", "Male", "Married"));
    persons.add(new Person("Laura", "Female", "Married"));
    persons.add(new Person("Diana", "Female", "Single"));
    persons.add(new Person("Mike", "Male", "Single"));
    persons.add(new Person("Bobby", "Male", "Single"));

    Criteria male = new CriteriaMale();
    Criteria female = new CriteriaFemale();
    Criteria single = new CriteriaSingle();
    Criteria singleMale = new AndCriteria(single, male);
    Criteria singleOrFemale = new OrCriteria(single, female);

    System.out.println("Males: ");
    printPersons(male.meetCriteria(persons));

    System.out.println("\nFemales: ");
    printPersons(female.meetCriteria(persons));

    System.out.println("\nSingle Males: ");
    printPersons(singleMale.meetCriteria(persons));

    System.out.println("\nSingle Or Females: ");
    printPersons(singleOrFemale.meetCriteria(persons));
  }

  public static void printPersons(List<Person> persons) {
    persons.forEach(p -> System.out.println(p));
  }
}
