package com.zhang.interview.code.design.behavioral.template;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Cricket
 * @Author: zxb
 * @Date: 2020/10/14 15:51
 * @Description: 模板模式-游戏实现类
 */
public class Cricket extends Game {

  @Override
  void initialize() {
    System.out.println("Cricket Game Initialized! Start playing.");
  }

  @Override
  void startPlay() {
    System.out.println("Cricket Game Started. Enjoy the game!");
  }

  @Override
  void endPlay() {
    System.out.println("Cricket Game Finished.");
  }
}
