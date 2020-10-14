package com.zhang.interview.code.design.servlet.mvc;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: MVCPatternDemo
 * @Author: zxb
 * @Date: 2020/10/14 17:09
 * @Description: MVC模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/mvc_pattern.htm
 */
public class MVCPatternDemo {

  public static void main(String[] args) {
    // fetch student record based on his roll no from the database
    Student student = retrieveStudentFromDatabase();

    // Create a view : to write student details on console
    StudentView view = new StudentView();

    StudentController controller = new StudentController(student, view);

    controller.updateView();

    // update model data
    controller.setStudentName("John");

    controller.updateView();
  }

  private static Student retrieveStudentFromDatabase() {
    Student student = new Student();
    student.setName("Robert");
    student.setRollNo("10");
    return student;
  }
}
