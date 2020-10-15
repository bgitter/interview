package com.zhang.interview.code.design.servlet.fc;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: FrontController
 * @Author: zxb
 * @Date: 2020/10/15 13:49
 * @Description: FC模式-控制器
 */
public class FrontController {

  private Dispatcher dispatcher;

  public FrontController() {
    dispatcher = new Dispatcher();
  }

  private boolean isAuthenticUser() {
    System.out.println("User is authenticated successfully.");
    return true;
  }

  private void trackRequest(String request) {
    System.out.println("Page requested: " + request);
  }

  public void dispatchRequest(String request) {
    // log each request
    trackRequest(request);

    // authenticate the user
    if (isAuthenticUser()) {
      dispatcher.dispatch(request);
    }
  }
}
