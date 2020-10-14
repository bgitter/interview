package com.zhang.interview.code.design.behavioral.mediator;

import java.util.Date;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ChatRoom
 * @Author: zxb
 * @Date: 2020/10/14 11:07
 * @Description: 中介模式-中介类
 */
public class ChatRoom {

  public static void showMessage(User user, String message) {
    System.out
        .println(String.format("%s [%s]: %s", new Date().toString(), user.getName(), message));
  }

}
