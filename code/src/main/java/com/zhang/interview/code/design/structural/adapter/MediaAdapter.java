package com.zhang.interview.code.design.structural.adapter;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: MediaAdapter
 * @Author: zxb
 * @Date: 2020/10/12 14:36
 * @Description: 适配器模式-适配器
 */
public class MediaAdapter implements MediaPlayer {

  AdvancedMediaPlayer advancedMediaPlayer;

  public MediaAdapter(String audioType) {
    if (audioType.equalsIgnoreCase("vlc")) {
      advancedMediaPlayer = new VlcPlayer();
    } else if (audioType.equalsIgnoreCase("mp4")) {
      advancedMediaPlayer = new Mp4Player();
    }
  }

  @Override
  public void play(String audioType, String fileName) {
    if (audioType.equalsIgnoreCase("vlc")) {
      advancedMediaPlayer.playVlc(fileName);
    } else if (audioType.equalsIgnoreCase("mp4")) {
      advancedMediaPlayer.playMp4(fileName);
    }
  }
}
