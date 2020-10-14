package com.zhang.interview.code.design.behavioral.mediator;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: User
 * @Author: zxb
 * @Date: 2020/10/14 11:07
 * @Description: 中介模式-用户类
 */
public class User {

  private String name;

  public User(String name) {
    this.name = name;
  }

  public void sendMessage(String message) {
    ChatRoom.showMessage(this, message);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
