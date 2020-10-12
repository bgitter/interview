package com.zhang.interview.code.design.structural.adapter;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: AudioPlayer
 * @Author: zxb
 * @Date: 2020/10/12 14:38
 * @Description: 适配器模式-播放器
 */
public class AudioPlayer implements MediaPlayer {

  MediaAdapter mediaAdapter;

  @Override
  public void play(String audioType, String fileName) {
    // inbuilt support to play mp3 music files
    if (audioType.equalsIgnoreCase("mp3")) {
      System.out.println("Playing mp3 file. Name: " + fileName);
    } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
      // mediaAdapter is providing support to play other file formats
      mediaAdapter = new MediaAdapter(audioType);
      mediaAdapter.play(audioType, fileName);
    } else {
      System.err.println("Invalid media. " + audioType + " format not supported");
    }
  }
}
