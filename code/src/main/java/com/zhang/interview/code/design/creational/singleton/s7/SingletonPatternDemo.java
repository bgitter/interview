package com.zhang.interview.code.design.creational.singleton.s7;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: SingletonPatternDemo
 * @Author: zxb
 * @Date: 2020/10/12 10:17
 * @Description: 单例模式-入口 饿汉模式 防止反射破坏单例模式
 */
public class SingletonPatternDemo {

  public static void main(String[] args)
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    Constructor<SingleObject> constructor = SingleObject.class.getDeclaredConstructor();
    // 获取私有构造器的访问权限
    constructor.setAccessible(true);
    SingleObject singleObject = constructor.newInstance();
    SingleObject instance = SingleObject.getInstance();
    System.out.println(singleObject == instance);
  }

}
