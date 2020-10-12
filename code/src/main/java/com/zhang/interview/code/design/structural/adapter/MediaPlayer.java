package com.zhang.interview.code.design.structural.adapter;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: MediaPlayer
 * @Author: zxb
 * @Date: 2020/10/12 14:31
 * @Description: 适配器模式-接口
 */
public interface MediaPlayer {

  /**
   * 播放
   *
   * @param audioType 类型
   * @param fileName  文件
   */
  void play(String audioType, String fileName);

}
