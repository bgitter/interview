package com.zhang.interview.code.design.structural.adapter;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: Mp4Player
 * @Author: zxb
 * @Date: 2020/10/12 14:35
 * @Description: 适配器模式-实现类
 */
public class Mp4Player implements AdvancedMediaPlayer {

  @Override
  public void playMp4(String fileName) {
    System.out.println("Playing mp4 file. Name: " + fileName);
  }
}
