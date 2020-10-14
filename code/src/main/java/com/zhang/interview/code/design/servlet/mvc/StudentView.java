package com.zhang.interview.code.design.servlet.mvc;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: StudentView
 * @Author: zxb
 * @Date: 2020/10/14 17:05
 * @Description: MVC模式-View对象
 */
public class StudentView {

  public void printStudentDetails(String studentName, String studentRollNo) {
    System.out.println("Student");
    System.out.println("Name: " + studentName);
    System.out.println("Roll No: " + studentRollNo);
  }

}
