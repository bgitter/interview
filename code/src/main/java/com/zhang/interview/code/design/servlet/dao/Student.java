package com.zhang.interview.code.design.servlet.dao;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Student
 * @Author: zxb
 * @Date: 2020/10/15 9:41
 * @Description: DAO模式-Model类
 */
public class Student {

  private String name;
  private int rollNo;

  public Student(String name, int rollNo) {
    this.name = name;
    this.rollNo = rollNo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getRollNo() {
    return rollNo;
  }

  public void setRollNo(int rollNo) {
    this.rollNo = rollNo;
  }
}
