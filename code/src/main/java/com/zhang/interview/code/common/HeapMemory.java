package com.zhang.interview.code.common;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: HeapMemory
 * @Author: zxb
 * @Date: 2020/10/15 14:28
 * @Description: 打印对象内存布局
 * 以64位操作系统为例（未开启指针压缩的情况，JDK默认是开启的，开启后klass pointer大小为4个字节，不开启则为8个字节）
 * 详细信息：https://www.toutiao.com/i6872618702160953863
 */
public class HeapMemory {

  public static class Item {

    byte i = 0;

  }

  public static void main(String[] args) {
    Item obj = new Item();
    System.out.println(ClassLayout.parseInstance(obj).toPrintable());
  }

}
