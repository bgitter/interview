package com.zhang.interview.code.design.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Employee
 * @Author: zxb
 * @Date: 2020/10/12 15:55
 * @Description: 组合模式-组合
 */
public class Employee {

  private String name;
  private String dept;
  private int salary;
  private List<Employee> subordinates;

  public Employee(String name, String dept, int salary) {
    this.name = name;
    this.dept = dept;
    this.salary = salary;
    this.subordinates = new ArrayList<>();
  }

  public void add(Employee e) {
    subordinates.add(e);
  }

  public void remove(Employee e) {
    subordinates.remove(e);
  }

  public List<Employee> getSubordinates() {
    return subordinates;
  }

  @Override
  public String toString() {
    return "Employee :[ Name : " + name + ", dept : " + dept + ", salary :" + salary + " ]";
  }
}
