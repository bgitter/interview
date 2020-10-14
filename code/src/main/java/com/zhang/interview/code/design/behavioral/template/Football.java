package com.zhang.interview.code.design.behavioral.template;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Football
 * @Author: zxb
 * @Date: 2020/10/14 15:52
 * @Description: 模板模式-游戏实现类
 */
public class Football extends Game {

  @Override
  void initialize() {
    System.out.println("Football Game Initialized! Start playing.");
  }

  @Override
  void startPlay() {
    System.out.println("Football Game Started. Enjoy the game!");
  }

  @Override
  void endPlay() {
    System.out.println("Football Game Finished.");
  }
}
