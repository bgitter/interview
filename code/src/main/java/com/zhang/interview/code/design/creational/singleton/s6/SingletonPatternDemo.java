package com.zhang.interview.code.design.creational.singleton.s6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: SingletonPatternDemo
 * @Author: zxb
 * @Date: 2020/10/12 11:04
 * @Description: 单例模式-入口
 */
public class SingletonPatternDemo {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    SerializationSingleton singleton = SerializationSingleton.getInstance();
    ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("SingletonFile"));
    outputStream.writeObject(singleton);

    ObjectInputStream inputStream = new ObjectInputStream(
        new FileInputStream(new File("SingletonFile")));
    SerializationSingleton newInstance = (SerializationSingleton) inputStream.readObject();
    System.out.println(singleton == newInstance);
  }

}
