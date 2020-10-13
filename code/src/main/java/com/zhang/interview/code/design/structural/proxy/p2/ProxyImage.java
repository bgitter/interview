package com.zhang.interview.code.design.structural.proxy.p2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ProxyImage
 * @Author: zxb
 * @Date: 2020/10/13 17:11
 * @Description: 代理模式-JDK动态代理
 */
public class ProxyImage implements InvocationHandler {

  /**
   * 目标对象
   */
  private Object target;

  public ProxyImage(Object target) {
    this.target = target;
  }

  public Object createObject() {
    return Proxy
        .newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
            this);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("jdk proxy begin...");
    Object result = method.invoke(target, args);
    System.out.println("jdk proxy end...");
    return result;
  }
}
