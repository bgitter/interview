package com.zhang.interview.code.design.structural.proxy.p3;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: CglibProxy
 * @Author: zxb
 * @Date: 2020/10/13 17:29
 * @Description: 代理模式-CGLib代理类
 */
public class CglibProxy implements MethodInterceptor {

  private Object target;

  public CglibProxy(Object target) {
    this.target = target;
  }

  public Object createProxyObject() {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(target.getClass());
    enhancer.setCallback(this);
    return enhancer.create();
  }

  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    System.out.println("cglib proxy begin...");
    Object result = method.invoke(target, objects);
    System.out.println("cglib proxy end...");
    return result;
  }
}
