package com.zhang.interview.code.design.servlet.dao;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: DaoPatternDemo
 * @Author: zxb
 * @Date: 2020/10/15 9:57
 * @Description: DAO模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm
 */
public class DaoPatternDemo {

  public static void main(String[] args) {
    StudentDao dao = new StudentDaoImpl();

    // print all students
    dao.getAllStudents().forEach(s -> System.out
        .println(String.format("Student: [RollNo: %s, Name: %s]", s.getRollNo(), s.getName())));
    System.out.println("");
    // update student
    Student student = dao.getAllStudents().get(0);
    student.setName("Michael");
    dao.updateStudent(student);

    // get the student
    student = dao.getStudent(0);
    System.out.println(
        String.format("Student: [RollNo: %s, Name: %s]", student.getRollNo(), student.getName()));
    System.out.println("");
    // delete the student
    dao.deleteStudent(student);
    dao.getAllStudents().forEach(s -> System.out
        .println(String.format("Student: [RollNo: %s, Name: %s]", s.getRollNo(), s.getName())));
  }

}
