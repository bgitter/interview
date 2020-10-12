package com.zhang.interview.code.design.creational.singleton.s8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: EnumInstanceTest
 * @Author: zxb
 * @Date: 2020/10/12 11:20
 * @Description: 单例模式-懒汉模式 枚举实现
 */
public class EnumInstanceTest {

  public static void main(String[] args)
      throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    // 序列化攻击
    EnumInstance instance = EnumInstance.getInstance();
    ObjectOutputStream outputStream = new ObjectOutputStream(
        new FileOutputStream("EnumSingletonFile"));
    outputStream.writeObject(instance);
    ObjectInputStream inputStream = new ObjectInputStream(
        new FileInputStream(new File("EnumSingletonFile")));

    EnumInstance newInstance = (EnumInstance) inputStream.readObject();
    System.out.println(instance == newInstance);

    // 反射攻击，Enum类中只有一个两个参数的构造器：Enum(String name, int ordinal)
    Constructor<EnumInstance> constructor = EnumInstance.class
        .getDeclaredConstructor(String.class, int.class);
    constructor.setAccessible(true);
    EnumInstance enumInstance = constructor.newInstance("name");
    System.out.println(instance == enumInstance);
  }

}
