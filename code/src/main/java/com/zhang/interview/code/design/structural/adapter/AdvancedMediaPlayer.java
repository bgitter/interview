package com.zhang.interview.code.design.structural.adapter;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: AdvancedMediaPlayer
 * @Author: zxb
 * @Date: 2020/10/12 14:32
 * @Description: 适配器模式-接口
 */
public interface AdvancedMediaPlayer {

  /**
   * 播放 Vlc
   *
   * @param fileName 文件
   */
  default void playVlc(String fileName) {
  }

  /**
   * 播放MP4
   *
   * @param fileName 文件
   */
  default void playMp4(String fileName) {
  }
}
