package com.zhang.interview.code.design.servlet.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: StudentDaoImpl
 * @Author: zxb
 * @Date: 2020/10/15 9:46
 * @Description: DAO模式-Dao实现类
 */
public class StudentDaoImpl implements StudentDao {

  /**
   * list is working as a database
   */
  List<Student> students;

  public StudentDaoImpl() {
    students = new ArrayList<>();
    students.add(new Student("Robert", 0));
    students.add(new Student("John", 1));
    students.add(new Student("Married", 3));
  }

  @Override
  public List<Student> getAllStudents() {
    return students;
  }

  @Override
  public Student getStudent(int rollNo) {
    return students.parallelStream().filter(s -> s.getRollNo() == rollNo).findFirst()
        .orElseGet(null);
  }

  @Override
  public void updateStudent(Student student) {
    Student data = getStudent(student.getRollNo());
    if (data != null) {
      data.setName(student.getName());
      System.out.println("Student: Roll No " + student.getRollNo() + ", updated in the database");
    }
  }

  @Override
  public void deleteStudent(Student student) {
    Iterator<Student> iterator = students.iterator();
    while (iterator.hasNext()) {
      Student obj = iterator.next();
      System.out.println("rollNo:" + obj.getRollNo());
      if (obj.getRollNo() == student.getRollNo()) {
        iterator.remove();
        System.out.println("Student: Roll No " + student.getRollNo() + ", deleted from database");
      }
    }
  }

  @Override
  public void addStudent(Student student) {
    students.add(student);
  }
}
