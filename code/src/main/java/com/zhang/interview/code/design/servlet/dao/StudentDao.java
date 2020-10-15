package com.zhang.interview.code.design.servlet.dao;

import java.util.List;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: StudentDao
 * @Author: zxb
 * @Date: 2020/10/15 9:41
 * @Description: DAO模式-dao接口
 */
public interface StudentDao {

  /**
   * getAllStudents
   *
   * @return students
   */
  List<Student> getAllStudents();

  /**
   * get Student
   *
   * @param rollNo no
   * @return student
   */
  Student getStudent(int rollNo);

  /**
   * update student
   *
   * @param student student
   */
  void updateStudent(Student student);

  /**
   * delete student
   *
   * @param student student
   */
  void deleteStudent(Student student);

  /**
   * add student
   *
   * @param student student
   */
  void addStudent(Student student);

}
