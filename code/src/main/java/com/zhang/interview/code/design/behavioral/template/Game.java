package com.zhang.interview.code.design.behavioral.template;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Game
 * @Author: zxb
 * @Date: 2020/10/14 15:48
 * @Description: 模板模式-模板抽象类
 */
public abstract class Game {

  /**
   * init
   */
  abstract void initialize();

  /**
   * start
   */
  abstract void startPlay();

  /**
   * end
   */
  abstract void endPlay();

  /**
   * play
   */
  public final void play() {
    // initialize the game
    initialize();

    // start game
    startPlay();

    // end game
    endPlay();
  }

}
