package com.zhang.interview.code.design.servlet.fc;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: FrontControllerPatternDemo
 * @Author: zxb
 * @Date: 2020/10/15 13:52
 * @Description: FC模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/front_controller_pattern.htm
 */
public class FrontControllerPatternDemo {

  public static void main(String[] args) {
    FrontController controller = new FrontController();
    controller.dispatchRequest("HOME");
    controller.dispatchRequest("STUDENT");
  }

}
