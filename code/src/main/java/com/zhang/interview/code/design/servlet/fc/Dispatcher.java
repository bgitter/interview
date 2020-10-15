package com.zhang.interview.code.design.servlet.fc;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Dispatcher
 * @Author: zxb
 * @Date: 2020/10/15 13:47
 * @Description: FC模式-调度器
 */
public class Dispatcher {

  private StudentView studentView;
  private HomeView homeView;

  public Dispatcher() {
    studentView = new StudentView();
    homeView = new HomeView();
  }

  public void dispatch(String request) {
    if (request.equalsIgnoreCase("STUDENT")) {
      studentView.show();
    } else {
      homeView.show();
    }
  }

}
