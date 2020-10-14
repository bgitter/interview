package com.zhang.interview.code.design.servlet.mvc;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: StudentController
 * @Author: zxb
 * @Date: 2020/10/14 17:06
 * @Description: MVC模式-Controller对象
 */
public class StudentController {

  private Student model;
  private StudentView view;

  public StudentController(Student model, StudentView view) {
    this.model = model;
    this.view = view;
  }

  public void setStudentName(String name) {
    model.setName(name);
  }

  public String getStudentName() {
    return model.getName();
  }

  public void setStudentRollNo(String rollNo) {
    model.setRollNo(rollNo);
  }

  public String getStudentRollNo() {
    return model.getRollNo();
  }

  public void updateView() {
    view.printStudentDetails(model.getName(), model.getRollNo());
  }
}
