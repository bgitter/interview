package com.zhang.interview.code.design.structural.filter;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Person
 * @Author: zxb
 * @Date: 2020/10/12 15:32
 * @Description: 过滤器模式-实体
 */
public class Person {

  private String name;
  private String gender;
  private String maritalStatus;

  public Person(String name, String gender, String maritalStatus) {
    this.name = name;
    this.gender = gender;
    this.maritalStatus = maritalStatus;
  }

  public String getName() {
    return name;
  }

  public String getGender() {
    return gender;
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }

  @Override
  public String toString() {
    return "Person : [ Name : " + name + ", Gender : " + gender + ", Marital Status : "
        + maritalStatus + " ]";
  }
}
