package com.zhang.interview.code.design.structural.adapter;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: VlcPlayer
 * @Author: zxb
 * @Date: 2020/10/12 14:34
 * @Description: 适配器模式-实现类
 */
public class VlcPlayer implements AdvancedMediaPlayer {

  @Override
  public void playVlc(String fileName) {
    System.out.println("Playing vlc file. Name: " + fileName);
  }
}
