package com.zhang.interview.code.design.structural.adapter;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: AdapterPatternDemo
 * @Author: zxb
 * @Date: 2020/10/12 14:41
 * @Description: 适配器模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/adapter_pattern.htm
 */
public class AdapterPatternDemo {

  public static void main(String[] args) {
    AudioPlayer audioPlayer = new AudioPlayer();
    audioPlayer.play("mp3", "beyoond the horizon.mp3");
    audioPlayer.play("mp4", "alone.mp4");
    audioPlayer.play("vlc", "far far away.vlc");
    audioPlayer.play("avi", "mind me.avi");
  }

}
