package com.zhang.interview.code.design.structural.bridge;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: DrawAPI
 * @Author: zxb
 * @Date: 2020/10/12 15:18
 * @Description: 桥接模式-接口
 */
public interface DrawAPI {

  /**
   * 画圆
   *
   * @param radius 半径
   * @param x      x坐标
   * @param y      y坐标
   */
  void drawCircle(int radius, int x, int y);

}
