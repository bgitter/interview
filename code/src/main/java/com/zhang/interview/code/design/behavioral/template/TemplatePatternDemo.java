package com.zhang.interview.code.design.behavioral.template;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: TemplatePatternDemo
 * @Author: zxb
 * @Date: 2020/10/14 15:53
 * @Description: 模板模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/template_pattern.htm
 */
public class TemplatePatternDemo {

  public static void main(String[] args) {
    Game game = new Cricket();
    game.play();
    System.out.println("");

    game = new Football();
    game.play();
  }

}
