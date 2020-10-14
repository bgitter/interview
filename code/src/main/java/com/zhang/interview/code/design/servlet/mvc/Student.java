package com.zhang.interview.code.design.servlet.mvc;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Student
 * @Author: zxb
 * @Date: 2020/10/14 17:04
 * @Description: MVC模式-Model对象
 */
public class Student {

  private String rollNo;

  private String name;

  public String getRollNo() {
    return rollNo;
  }

  public void setRollNo(String rollNo) {
    this.rollNo = rollNo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
